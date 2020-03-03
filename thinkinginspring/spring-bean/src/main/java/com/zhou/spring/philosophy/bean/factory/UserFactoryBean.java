package com.zhou.spring.philosophy.bean.factory;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link com.zhou.spring.philosophy.ioc.container.overview.domain.User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * Created on 2020/3/3 10:30 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class UserFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
