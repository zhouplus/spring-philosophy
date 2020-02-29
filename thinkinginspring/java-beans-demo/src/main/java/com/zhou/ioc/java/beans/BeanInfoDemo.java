package com.zhou.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 * Created on 2020/2/29 4:56 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        //Java Bean 自省 的方式获得 Bean Info
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        //使用stream接收，来存储结果
        Stream.of(beanInfo.getPropertyDescriptors())
            .forEach(propertyDescriptor -> {

                //PropertyDescriptor 允许添加属性编辑器  - PropertyEditor
                // GUI -> text(String) -> PropertyType

                // name -> String
                // age -> Integer
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                String propertyName = propertyDescriptor.getName();

                if("age".equals(propertyName)){
                    //String -> Integer
                    propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    //如果是需要传入bean 实例的话的
                    propertyDescriptor.createPropertyEditor(null);
                }

                System.out.println(propertyDescriptor);
            })
        ;

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            //暂存为了GetValue取
            setValue(value);
        }
    }

}
