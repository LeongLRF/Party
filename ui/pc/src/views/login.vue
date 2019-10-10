<template>
  <div class="login_form">
    <img src="../assets/123.png" alt="" width="250px">
    <div>
      <a-row>
        <a-input class="input" v-model="username">
          <a-icon slot="prefix" type="user" />
        </a-input>
      </a-row>
      <a-row>
        <a-input class="input" v-model="password" type="password">
          <a-icon slot="prefix" type="lock" />
        </a-input>
      </a-row>
      <a-row>
        <a-button @click="login">登录</a-button>
      </a-row>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login () {
      if (this.userName === '' || this.userName === null) {
        this.$message.error('请输入账号')
        return
      }
      if (this.password === '' || this.password === null) {
        this.$message.error('请输入密码')
        return
      }
      this.$post('/sys/login', { userName: this.username, password: this.password }).then(res => {
        if (res.success) {
          this.$message.success('登录成功')
          this.$router.push('/')
        }
      })
    }
  },
  mounted () {
    let that = this
    document.onkeydown = function (e) {
      let key = window.event.keyCode
      if (key === 13) {
        that.login()
      }
    }
  }
}
</script>

<style>
.login_form {
  background-color: #de2910;
  height: 1007px;
  text-align: center;
}
.login_form img {
  margin-top: 190px;
}
.input {
  width: 15%;
  margin: 10px;
}
</style>
