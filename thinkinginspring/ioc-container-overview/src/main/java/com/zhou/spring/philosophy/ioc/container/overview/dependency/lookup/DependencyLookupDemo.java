package com.zhou.spring.philosophy.ioc.container.overview.dependency.lookup;

import com.zhou.spring.philosophy.ioc.container.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称查找
 * 2. 通过类型查找
 *
 *
 *
 * Created on 2020/2/29 6:36 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

        //配置 XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        //lookupInRealTime(beanFactory);
        //lookupInLazyTime(beanFactory);


        //按照类型查找
        lookupByType(beanFactory);
        //按照类型查找一个集合
        lookupCollectionByType(beanFactory);


    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按照类型查找一个集合->" + beansOfType);
        }

    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按照类型查找单个:" + user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {

        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("beanFactory");
        User user = userObjectFactory.getObject();
        System.out.println("延迟查找：" + user);

    }

    private static void lookupInRealTime(BeanFactory beanFactory) {

        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }
}
