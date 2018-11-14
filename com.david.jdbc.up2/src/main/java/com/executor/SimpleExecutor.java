package com.executor;

import com.config.Configuration;
import com.mapper.MapperData;
import com.mapper.MapperRegistory;
import com.statement.StatementHandler;

/**
 * Created by sc on 2018/11/12.
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperData mapperData, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query( mapperData,parameter);
    }
}
