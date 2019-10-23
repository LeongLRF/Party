package com.wyu.partymanager.utils;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isBlank;

@UtilityClass
public class StringUtil {

    public Optional<String> maybe(@Nullable String string) {
        return string != null && !isBlank(string) ? Optional.of(string) : Optional.empty();
    }
}
