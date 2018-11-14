package com.mapper;

import com.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by sc on 2018/11/12.
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;
    private Class clazz;

    public MapperProxy(SqlSession sqlSession, Class clazz) {
        this.sqlSession = sqlSession;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.getClass().getName();
        MapperData mapperData=MapperRegistory.registerData.get(clazz.getName()+"."+method.getName());
        if((mapperData.getName_space()+"."+mapperData.getMethod()).equalsIgnoreCase(clazz.getName()+"."+method.getName())){
            return sqlSession.selectOne(mapperData, args[0]);
        }
        return method.invoke(args);
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
