package com.lagou.orm.client.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;

/**
 * @Author: fengyibo
 * @Date: 2020/3/29 21:43
 * @Description:
 */
public class OrderService {

    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

}
