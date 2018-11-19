package com.plugins;

import com.annotation.ConsumIntercepts;
import com.annotation.ConsumSignature;
import com.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Properties;

/**
 * Created by sc on 2018/11/14.
 */
@ConsumIntercepts({@ConsumSignature(type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class TestPlugin implements ConsumInterceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object object) {
        return Plugins;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
