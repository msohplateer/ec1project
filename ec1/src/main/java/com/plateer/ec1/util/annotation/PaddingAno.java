package com.plateer.ec1.util.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(ElementType.FIELD)
public @interface PaddingAno {
    String input();
    int length();
}
