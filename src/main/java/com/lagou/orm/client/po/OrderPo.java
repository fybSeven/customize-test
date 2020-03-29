package com.lagou.orm.client.po;

import lombok.Data;

/**
 * @Author: fengyibo
 * @Date: 2020/3/29 21:45
 * @Description:
 */
@Data
public class OrderPo {

    private Integer id;

    private String desc;

    private Integer uid;

    @Override
    public String toString() {
        return "OrderPo{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", uid=" + uid +
                '}';
    }
}
