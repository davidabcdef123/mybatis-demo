package com.annotation;

import java.lang.annotation.*;

/**
 * Created by sc on 2018/11/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ConsumIntercepts {

    ConsumSignature[] value();
}
