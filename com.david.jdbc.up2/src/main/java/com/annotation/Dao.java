package com.annotation;

import java.lang.annotation.*;

/**
 * Created by sc on 2018/11/12.
 */
//存活时间
@Retention(RetentionPolicy.RUNTIME)
//注解运用的地方
@Target({ElementType.TYPE})
//会在javadoc中出现
@Documented
public @interface Dao {
}
