package com.executor;

import com.mapper.MapperData;
import com.mapper.MapperRegistory;

/**
 * Created by sc on 2018/11/12.
 */
public interface Executor {

    <T>T query(MapperData mapperData, Object parameter)throws Exception;
}
