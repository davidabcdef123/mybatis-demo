package com.executor;

import com.config.Configuration;
import com.mapper.MapperData;
import com.mapper.MapperRegistory;
import com.statement.StatementHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sc on 2018/11/12.
 */
public class CachingExexutor implements Executor {


    public static Map<String, Object> cacheMap = new HashMap<>();

    private Configuration configuration;

    public CachingExexutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperData mapperData, Object parameter) throws Exception {
        if(cacheMap.get(mapperData.getName_space()+"."+mapperData.getMethod())!=null){
            return (T) cacheMap.get(mapperData.getName_space()+"."+mapperData.getMethod());
        }else{
            StatementHandler statementHandler = new StatementHandler(configuration);
        }
        return null;
    }
}
