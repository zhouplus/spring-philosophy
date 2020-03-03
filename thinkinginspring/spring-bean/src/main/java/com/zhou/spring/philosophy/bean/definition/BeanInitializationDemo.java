package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.bean.factory.DefaultUserFactory;
import com.zhou.spring.philosophy.bean.factory.UserFactory;
import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化Demo
 * Created on 2020/3/3 11:30 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
@Configuration // 写不写都行 表示 是 一个 Configuration Class
public class BeanInitializationDemo {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanInitializationDemo.class);
        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.close();
    }

    @Bean(initMethod = "initMethod")
    public UserFactory userFactory() {
        UserFactory userFactory = new DefaultUserFactory();
        return userFactory;

    }
}
