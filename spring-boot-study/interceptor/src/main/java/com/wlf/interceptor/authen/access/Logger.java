package com.wlf.interceptor.authen.access;

import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logger {

    String operations() default "";

}
