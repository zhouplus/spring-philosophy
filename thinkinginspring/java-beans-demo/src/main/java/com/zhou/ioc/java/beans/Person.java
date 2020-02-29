package com.zhou.ioc.java.beans;

/**
 * 描述人的POJO类
 * Created on 2020/2/29 4:52 下午
 *
 * Setter            / Getter 方法
 * 在Java Beans中叫做：可写方法(Writable) / 可读方法(Readable)
 *
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class Person {

    // String -> String
    private String name;// 在Java Beans中叫 Property

    // String -> Integer
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
