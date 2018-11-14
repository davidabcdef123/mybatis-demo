package com.mapper;

import com.annotation.Dao;
import com.annotation.SqlTag;
import com.session.SqlSession;
import com.vo.TestVo;

/**
 * Created by sc on 2018/11/12.
 */
@Dao
public interface TestMapper {

    @SqlTag(sql="select * from test where id=%d")
    public TestVo getTestVo(int id);

}
