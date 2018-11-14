package com;

import com.config.Configuration;
import com.executor.ExecutorFactory;
import com.executor.SimpleExecutor;
import com.mapper.TestMapper;
import com.session.SqlSession;
import com.vo.TestVo;

/**
 * Created by sc on 2018/11/12.
 */
public class BootStrap {

    public static void main(String[] args) throws Exception {
        //加载config
        Configuration configuration = new Configuration("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        ,null,"root","root",new Class[]{TestMapper.class, TestVo.class});
        //opensession
        SqlSession sqlSession=new SqlSession(configuration, ExecutorFactory.get(ExecutorFactory.SIMPLE_EXECTOR,configuration));
        TestMapper testMapper=sqlSession.getMapper(TestMapper.class);
        System.out.println(testMapper.getTestVo(1));
        //拿到结果
    }
}
