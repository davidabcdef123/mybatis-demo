package com.result;

import com.config.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sc on 2018/11/12.
 */
public class ResultSetHandler {

    private Configuration configuration;

    public ResultSetHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    //1handle
    public <T>T handle(ResultSet resultSet,Class clazz) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object returnObj=clazz.newInstance();
        if(resultSet.next()){
            for(Field field:clazz.getDeclaredFields()){
                setValues(field, returnObj,resultSet);
            }

        }
        return (T) returnObj;
    }

    private void setValues(Field field, Object returnObj,ResultSet resultSet) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method method=returnObj.getClass().getMethod("set" + upperCapital(field.getName()),field.getType());
        method.invoke(returnObj,getResult(field,resultSet));
    }

    private Object getResult(Field field,ResultSet resultSet) throws SQLException {
        //todo typehandler
        Class type=field.getType();
        if(Integer.class==type){
            return resultSet.getInt(field.getName());
        }if(String.class==type){
            return resultSet.getString(field.getName());
        }
        return resultSet.getString(field.getName());
    }

    //3 getResult
    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }

}
