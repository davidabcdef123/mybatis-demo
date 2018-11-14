package com.executor;

import com.config.Configuration;
import com.mapper.MapperRegistory;

/**
 * Created by sc on 2018/11/12.
 */
public class ExecutorFactory {

    public static final String SIMPLE_EXECTOR="simple";

    public static final String CACHE_EXECTOR = "cache";

    public static Executor get(String exectorType,Configuration configuration) throws Exception {
        if(exectorType.equalsIgnoreCase(SIMPLE_EXECTOR)){
            return new SimpleExecutor(configuration);
        }else if(exectorType.equalsIgnoreCase(CACHE_EXECTOR)){
            return new CachingExexutor(configuration);
        }
        throw new Exception("创建exector异常");
    }

    static enum ExecutorType{
        SIMPLE,CHACHE
    }


}
