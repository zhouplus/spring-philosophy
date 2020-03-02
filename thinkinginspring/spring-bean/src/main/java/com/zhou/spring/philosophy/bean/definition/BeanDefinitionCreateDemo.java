package com.zhou.spring.philosophy.bean.definition;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * Created on 2020/3/2 10:34 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class BeanDefinitionCreateDemo {

    public static void main(String[] args) {

        // 1. 通过 BeanDefinitionBuilder 来构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
//        beanDefinitionBuilder.addPropertyValue("id",1);
//        beanDefinitionBuilder.addPropertyValue("name","舟");
        beanDefinitionBuilder.addPropertyValue("id",1)
                                .addPropertyValue("name","舟");
        // 获取  BeanDefinition  实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非 Bean 终态，可以自定义修改

        //2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id",1);
//        propertyValues.addPropertyValue( "name","舟");

        propertyValues.add("id",1)
                .add("name","洲");
        genericBeanDefinition.setPropertyValues(propertyValues);


    }

}
