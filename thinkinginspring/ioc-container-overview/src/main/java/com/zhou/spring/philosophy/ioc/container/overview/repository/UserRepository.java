package com.zhou.spring.philosophy.ioc.container.overview.repository;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户信息仓库
 * Created on 2020/2/29 7:34 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class UserRepository {

    //来自于自己定义的bean
    private Collection<User> users;

    // 来自于内建 非 Bean 对象 (依赖)
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
