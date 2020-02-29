package com.zhou.spring.philosophy.ioc.container.overview.repository;

import com.zhou.spring.philosophy.ioc.container.overview.domain.User;

import java.util.Collection;

/**
 * 用户信息仓库
 * Created on 2020/2/29 7:34 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
public class UserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
