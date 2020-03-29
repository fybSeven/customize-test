package com.lagou.orm.client.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.orm.client.dao.UserDao;
import com.lagou.orm.client.dao.UserMapper;
import com.lagou.orm.client.po.UserPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.List;

/**
 * @Author: fengyibo
 * @Date: 2020/3/27 22:34
 * @Description:
 */
public class UserService {

    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void findAll(){
        PageHelper.startPage(1,2);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserPO> userPOS = userDao.findAll();
        for (UserPO userPO : userPOS) {
            System.out.println(userPO);
        }
        PageInfo<UserPO> pageInfo = new PageInfo<>(userPOS);
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("是否为最后一页"+pageInfo.isIsLastPage());
    }

    @Test
    public void findOrder(){
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserPO> userPOS = userDao.findUserOrders(1);
        for (UserPO userPO : userPOS) {
            System.out.println(userPO);
        }
    }

    @Test
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserPO userPO = mapper.selectOne(new UserPO(1, null));
        System.out.println(userPO);
        Example example=new Example(UserPO.class);
        example.createCriteria().andLike("username", "%李%");
        List<UserPO> users1 = mapper.selectByExample(example);
        System.out.println(users1);
    }



}
