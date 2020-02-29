package com.zhou.spring.philosophy.ioc.container.overview.dependency.injection;

import com.zhou.spring.philosophy.ioc.container.overview.annotation.Super;
import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import com.zhou.spring.philosophy.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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
       // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository",UserRepository.class);
       // System.out.println(userRepository.getUsers());

        //依赖注入
        //System.out.println(userRepository.getBeanFactory());
        //System.out.println(userRepository.getBeanFactory() == beanFactory);


        // 依赖查找，这里结果报错，证明依赖查找和依赖注入不一样
        // 那么依赖查找和依赖注入都是依赖，他们的bean是来自于一个地方吗？是同源吗？答案是否定的
        //(错误)
        //System.out.println(beanFactory.getBean(BeanFactory.class));


        //ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
        //答案是superUser对象，原因是superUser对象我们定义了 Primary
        //System.out.println(userObjectFactory.getObject());

//        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
////        System.out.println(objectFactory.getObject() == beanFactory);

        //依赖来源一： 自定义 Bean
        //UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository",UserRepository.class);
        // System.out.println(userRepository.getUsers());

        //依赖来源二： 依赖注入（内建 依赖）
        //System.out.println(userRepository.getBeanFactory());

        //依赖来源三： 容器内建的 Bean
//        Environment environment = beanFactory.getBean(Environment.class);
//        System.out.println("获取 Environment 类型的Bean -> " + environment);


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository",UserRepository.class);
        whoIsIocContainer(userRepository,applicationContext);

    }

    private static void whoIsIocContainer(UserRepository userRepository, ApplicationContext applicationContext) {
        //这个表达式为什么不成立？
        System.out.println(userRepository.getBeanFactory() == applicationContext.getParentBeanFactory());


        // ApplicationContext is BeanFactory
    }
}
