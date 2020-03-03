package com.zhou.spring.philosophy.bean.factory;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;

/**
 * {@link com.zhou.spring.philosophy.ioc.container.overview.domain.User} 工厂类
 * Created on 2020/3/3 10:13 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
