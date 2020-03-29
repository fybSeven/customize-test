package com.lagou.orm.client.dao;


import com.lagou.orm.client.po.UserPO;

import java.util.List;

/**
 * @Author: fengyibo
 * @Date: 2020/3/26 21:59
 * @Description:
 */
public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    List<UserPO> findAll();

    /**
     * 按id查询
     * @param user
     * @return
     */
    UserPO findById(UserPO user);
}
