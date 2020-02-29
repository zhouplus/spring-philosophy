package com.zhou.spring.philosophy.ioc.container.overview.dependency.lookup;

import com.zhou.spring.philosophy.ioc.container.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找示例
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

        User user = (User) beanFactory.getBean("user");

        System.out.println(user);


    }
}
