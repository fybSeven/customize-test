package com.lagou.orm.client.po;

import lombok.Data;

import java.util.List;

/**
 * @Author: fengyibo
 * @Date: 2020/3/26 21:49
 * @Description:
 */
@Data
public class UserPO {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 订单信息
     */
    private List<OrderPo> orders;

    public UserPO() {
    }

    public UserPO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", orders=" + orders +
                '}';
    }
}
