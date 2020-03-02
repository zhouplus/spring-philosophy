package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 * Created on 2020/3/2 11:19 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        //配置 XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        //通过别名 zhou-user 获取曾用名 user 的 bean
        User zhouUser = beanFactory.getBean("zhou-user",User.class);
        User user = beanFactory.getBean("user",User.class);
        System.out.println("zhou-user 与 user 是否相等" + (zhouUser == user));
        //return : zhou-user 与 user 是否相等true


    }
}
