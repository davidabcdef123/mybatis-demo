package com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sc on 2018/11/11.
 */
public class TestMapperXml {

    public static final String nameSpace = "com.TestMapper";
    public static final Map<String, Object> registerSql = new HashMap<>();



    static {
        registerSql.put("selectByPrimaryKey", "select * from test where id=%d");
    }
}
