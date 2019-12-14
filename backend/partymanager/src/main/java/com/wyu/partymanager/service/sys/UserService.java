package com.wyu.partymanager.service.sys;

import com.wyu.partymanager.entity.sys.Clazz;
import com.wyu.partymanager.entity.sys.Token;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.servicedao.UserServiceDao;
import com.wyu.partymanager.utils.Preloader;
import com.wyu.partymanager.utils.Result;
import core.inerface.IDbConnection;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * @author Leong
 * @date 2019/9/21 13:15
 */
@Service
public class UserService implements UserServiceDao {

    private final IDbConnection dbConnection;

    public UserService(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Result<User> add_user(User user) {
        if (validSameUser(user)) {
            return Result.error("用户已存在");
        }
        user.setRoleId(2);
        user.setSalt(UUID.randomUUID().toString());
        user.setPassword(encryptPassword(user.getSalt(), user.getPassword()));
        this.dbConnection.insert(user);
        return Result.ok(user);
    }

    @Override
    public Result<User> getById(Object id) {
        return Result.ok(dbConnection.getById(User.class, (Serializable) id));
    }

    @Override
    public Result<?> delete_user(long id) {
        dbConnection.deleteById(User.class,id);
        return Result.ok();
    }

    @Override
    public Result<User> edit_user(User user) {
        dbConnection.update(user);
        return Result.ok(user);
    }


    @Override
    public Result<List<User>> user_list(User.Filter filter) {
        List<User> users = dbConnection.form(User.class).apply(filter).toList();
        new Preloader<>(dbConnection, users)
                .preload_one(Clazz.class, User::getClassId, Clazz::getId, "id", User::setClazz);
        return Result.ok(users);
    }

    @Override
    public User findByUserName(String userName) {
        return dbConnection.form(User.class).whereEq("userName",userName).one();
    }

    @Override
    public Result<User> login(String userName, String password, HttpServletResponse response) {
        return Result.maybe(findByUserName(userName), "用户不存在")
                .andThenCheck(user -> validPassword(password, user), "密码错误")
                .andThenCheck(User::isValid, "对不起，该账号已被冻结")
                .andThen(user -> {
                    Token token = dbConnection.form(Token.class).whereEq("userId", user.getId()).one();
                    if (token != null) {
                        dbConnection.deleteById(Token.class, token.getToken());
                    }
                    String newToken = UUID.randomUUID().toString().replace("-", "");
                    Token token1 = new Token();
                    token1.setToken(newToken);
                    token1.setUserId(user.getId());
                    dbConnection.insert(token1);
                    Cookie cookie = new Cookie("token", newToken);
                    cookie.setPath("/");
                    cookie.setMaxAge(30 * 24 * 3600);
                    response.addCookie(cookie);
                    return Result.ok(user);
                });
    }

    private String encryptPassword(String salt, String password) {
        String str = salt + "---" + password;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] b = str.getBytes();
        byte[] digest = md5.digest(b);
        return Base64.getEncoder().encodeToString(digest);
    }

    public Result<List<User>> getUsers() {
        return Result.ok(dbConnection.form(User.class).whereEq("id", 2).toList());
    }

    private boolean validSameUser(User user) {
        return findByUserName(user.getUserName()) != null;
    }

    private boolean validPassword(String password, User user) {
        return encryptPassword(user.getSalt(), password).equals(user.getPassword());
    }
}
