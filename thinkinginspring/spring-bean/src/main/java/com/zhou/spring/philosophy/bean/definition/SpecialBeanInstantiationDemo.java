package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.bean.factory.DefaultUserFactory;
import com.zhou.spring.philosophy.bean.factory.UserFactory;
import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * 特殊方式  Bean  实例化示例
 * Created on 2020/3/3 10:07 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        //启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        //通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());

//        ServiceLoader<UserFactory> userFactoryServiceLoader = beanFactory.getBean("userFactoryServiceLoader",ServiceLoader.class);
//        displayServiceLoader(userFactoryServiceLoader);
//
//
//        demoServiceLoader();

    }


    public static void demoServiceLoader(){
        //区别在于这里如果接口有多种实现，会逐一输出，ServiceLoaderFactoryBean 不会,除非使用ServiceListFactoryBean
        ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);

    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().createUser());
        }
    }
}
