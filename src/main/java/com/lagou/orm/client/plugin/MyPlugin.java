package com.lagou.orm.client.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: fengyibo
 * @Date: 2020/3/29 21:57
 * @Description: 自定义mybatis插件
 */
@Intercepts({ //设置插件
        @Signature(type = StatementHandler.class, //设置要拦截的类
        method = "prepare", //设置拦截其中的那个方法
        args = {Connection.class, Integer.class}) //设置方法中的参数，防止方法重载
})
public class MyPlugin implements Interceptor {

    /**
     * 拦截方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("方法增强");
        return invocation.proceed();
    }

    /**
     * 把拦截器生成代理放入调用链中
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("代理对象："+ target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("配置插件初始化参数" + properties);
    }
}
