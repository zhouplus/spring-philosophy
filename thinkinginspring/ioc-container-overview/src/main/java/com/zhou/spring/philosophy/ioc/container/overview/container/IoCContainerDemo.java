package com.zhou.spring.philosophy.ioc.container.overview.container;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * IoC容器示例
 * Created on 2020/2/29 8:54 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class IoCContainerDemo {

    public static void main(String[] args) {

        //创建 BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        //Xml 配置文件  ClassPath 路径 classpath:/META-INF/dependency-lookup-context.xml
        String location = "classpath:/META-INF/dependency-lookup-context.xml";

        //加载配置
        int beanDefinitionsCounter = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量 -> " + beanDefinitionsCounter);

        //依赖查找集合对象
        lookupCollectionByType(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按照类型查找一个集合->" + beansOfType);
        }

    }

}
