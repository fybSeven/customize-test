package com.lagou.orm.client.po;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: fengyibo
 * @Date: 2020/3/26 21:49
 * @Description:
 */
@Data
@ToString
public class UserPO {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    public UserPO() {
    }

    public UserPO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
