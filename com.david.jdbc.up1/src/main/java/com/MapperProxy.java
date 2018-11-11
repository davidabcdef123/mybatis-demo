package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sc on 2018/11/11.
 */
public class MapperProxy implements InvocationHandler {

    private Class<?> clazz;
    private SqlSession sqlSession;

    public MapperProxy(Class<?> clazz, SqlSession sqlSession) {
        this.clazz = clazz;
        this.sqlSession = sqlSession;
    }

    public MapperProxy(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1遍历所有的namespace拿出匹配的namespace,没有注册试的bean和配置文件简单模拟下
        if(clazz.getName().equals(TestMapperXml.nameSpace)){
            String sql = (String) TestMapperXml.registerSql.get(method.getName());
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", sql, args[0]));
            return sqlSession.selectOne(sql, args[0]);
            //其实应该这么做method.invoke(proxy, args);
        }
        return null;
    }
}
