package com.lagou.orm.client.service;

import com.lagou.orm.client.dao.UserDao;
import com.lagou.orm.client.po.UserPO;
import com.lagou.orm.io.Resource;
import com.lagou.orm.sqlSession.SqlSession;
import com.lagou.orm.sqlSession.SqlSessionFactory;
import com.lagou.orm.sqlSession.SqlSessionFactoryBuild;
import org.junit.Test;

/**
 * @Author: fengyibo
 * @Date: 2020/3/27 22:34
 * @Description:
 */
public class UserService {

    @Test
    public void findAll() throws Exception {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuild.build(Resource.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserPO userPO = sqlSession.findOne("com.lagou.orm.client.dao.UserDao.findById", new UserPO(1, ""));
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        UserPO userPO = mapper.findById(new UserPO(1, ""));
        System.out.println(userPO);
    }

}
