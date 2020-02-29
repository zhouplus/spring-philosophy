package com.zhou.spring.philosophy.ioc.container.overview.container;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * IoC容器示例
 * Created on 2020/2/29 8:54 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
//@Configuration
public class AnnotationApplicationContextIoCContainerDemo {

    public static void main(String[] args) {

        //创建 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为 AnnotationApplicationContextIoCContainerDemo 配置类(Configuration Class)
        applicationContext.register(AnnotationApplicationContextIoCContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();

        //依赖查找集合对象
        lookupCollectionByType(applicationContext);

    }

    /**
     * 通过 Java 注解的方式，定义了一个 Bean
     * @return
     */
    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("哈哈");
        return user;
    }




    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按照类型查找一个集合->" + beansOfType);
        }

    }

}
