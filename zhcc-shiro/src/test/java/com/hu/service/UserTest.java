package com.hu.service;

import com.hu.zhcc.BaseJunit4Test;
import com.hu.zhcc.shiro.service.UserService;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;


@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring-test-mybatis.xml"}) //加载配置文件
public class UserTest extends BaseJunit4Test {

    @Resource
    private UserService userService;

    @Test
    public void testUserLogin() {
        System.out.println( userService.getByLoginName("admin").getPassword());
    }
}
