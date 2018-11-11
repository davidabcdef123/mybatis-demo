package com;

/**
 * Created by sc on 2018/11/11.
 */
public class BootStrap {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        TestMapper testMapper=sqlSession.getMapper(TestMapper.class);
        System.out.println(testMapper.selectByPrimaryKey(1));
    }
}
