package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean实例化示例
 * Created on 2020/3/3 10:07 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");


        User userByStaticMethod = beanFactory.getBean("user-by-static-method",User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instantce-method",User.class);
        User userByFactoryBean= beanFactory.getBean("user-by-factory-bean",User.class);

        System.out.println(userByStaticMethod);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println(userByInstanceMethod == userByStaticMethod);
        System.out.println(userByFactoryBean == userByInstanceMethod);
        System.out.println(userByFactoryBean == userByStaticMethod);


    }
}
