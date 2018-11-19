package com.plugins;

import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * Created by sc on 2018/11/14.
 */
public interface ConsumInterceptor {

    Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Object object);

    void setProperties(Properties properties);
}
