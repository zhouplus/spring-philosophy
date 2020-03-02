package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition 示例
 * Created on 2020/3/2 11:59 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */

@Import(AnnotationBeanDefinitionDemo.Config.class) // 3. 通过 @Import 导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration （配置类）
        applicationContext.register(Config.class);

        // 通过BeanDefinition注册 API 来实现
        // 1. 命名Bean 的方式注册
        registerUserDefinitionBean(applicationContext,"plus-user");
        // 2. 非命名Bean 的方式注册
        registerUserDefinitionBean(applicationContext);

        // 启动上下文
        applicationContext.refresh();

        // 按照类型查找  结果：不会重复注册
        System.out.println("通过类型查找 Config 类型的Bean 结果 : " + applicationContext.getBeansOfType(Config.class));
        System.out.println("通过类型查找 User 类型的Bean 结果 : " + applicationContext.getBeansOfType(User.class));

        // 显式关闭应用上下文
        applicationContext.close();
    }


    /**
     *
     * @param registry
     * @param beanName
     */
    public static void  registerUserDefinitionBean(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",1)
                .addPropertyValue("name","舟a");

        if(StringUtils.hasText(beanName)){
            //注册 BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }

    /**
     * 命名Bean的注册方式
     *
     * @param registry
     */
    public static void  registerUserDefinitionBean(BeanDefinitionRegistry registry){
        registerUserDefinitionBean(registry,null);
    }

    //2. 通过 @Component 定义
    @Component
    public static class Config{
        //  1. 通过@Bean 的方式定义
        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         * @return
         */
        @Bean( name = {"user","zhou-user"})
        public User user(){
            User user = new User();
            user.setId(1);
            user.setName("哈哈");
            return user;
        }
    }
}
