package com.lagou.orm.client.dao;


import com.lagou.orm.client.po.UserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: fengyibo
 * @Date: 2020/3/26 21:59
 * @Description:
 */
//开启二级缓存
@CacheNamespace
public interface UserDao {

    @Select("SELECT * FROM user")
    List<UserPO> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "orders", column = "id", javaType = List.class,
                    many = @Many(select = "com.lagou.orm.client.dao.OrderDao.findOrderByUid"))

    })
    List<UserPO> findUserOrders(Integer id);

}
