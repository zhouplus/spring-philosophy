package com.zhou.spring.philosophy.ioc.container.overview.dependency.injection;

import com.zhou.spring.philosophy.ioc.container.overview.annotation.Super;
import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import com.zhou.spring.philosophy.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入
 *
 * Created on 2020/2/29 6:36 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        //配置 XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository.getUsers());

    }
}
