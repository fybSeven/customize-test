package com.lagou.orm.client.dao;

import com.lagou.orm.client.po.OrderPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: fengyibo
 * @Date: 2020/3/29 21:43
 * @Description:
 */
public interface OrderDao {

    @Select("SELECT * FROM `order` WHERE uid = #{uid}")
    List<OrderPo> findOrderByUid(Integer uid);
}
