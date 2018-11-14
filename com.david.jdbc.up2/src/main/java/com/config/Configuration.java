package com.config;

import com.annotation.Dao;
import com.annotation.SqlTag;
import com.executor.Executor;
import com.mapper.MapperData;
import com.mapper.MapperRegistory;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by sc on 2018/11/12.
 */
public class Configuration {

    private String dirver;
    private String url;
    private String dbName;
    private String username;
    private String password;
    private Class[] classesList;

    public Configuration(String dirver, String url, String dbName, String username, String password, Class[] classesList) throws ClassNotFoundException {
        this.dirver = dirver;
        this.url = url;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
        this.classesList = classesList;
        registerMap(classesList);
    }


    public void registerMap(Class[] clazzList) throws ClassNotFoundException {
        if (clazzList != null && clazzList.length > 0) {
            for (int i = 0; i < clazzList.length; i++) {
                Class aClass = clazzList[i];
                boolean isDao = aClass.isAnnotationPresent(Dao.class);
                if (isDao) {
                    Method[] methodList = aClass.getMethods();
                    if (methodList != null) {
                        for (int j = 0; j < methodList.length; j++) {
                            Method method = methodList[j];
                            MapperData mapperData = new MapperData();
                            mapperData.setSql(method.getAnnotation(SqlTag.class).sql());
                            mapperData.setMethod(method.getName());
                            mapperData.setName_space(aClass.getName());
                            mapperData.setResultType(method.getReturnType());
                            MapperRegistory.registerData.put(aClass.getName() + "." + method.getName(), mapperData);
                        }
                    }

                }
            }
        }
    }

    //todo 扫描包下的文件并带有sqltag注解的

    public String getDirver() {
        return dirver;
    }

    public void setDirver(String dirver) {
        this.dirver = dirver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
