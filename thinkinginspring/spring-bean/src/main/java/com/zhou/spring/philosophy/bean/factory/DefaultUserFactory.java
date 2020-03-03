package com.zhou.spring.philosophy.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 默认 {@link UserFactory} 的实现
 * Created on 2020/3/3 10:20 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {




    @PostConstruct
    private  void init(){
        System.out.println("@PostConstruct 初始化 Bean 的方法。。。");

    }

    public  void initMethod(){
        System.out.println("@Bean initMethod #initMethod 初始化 Bean 的方法。。。");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Implements InitializingBean #afterPropertiesSet 初始化 Bean 的方法。。。");
    }
}
