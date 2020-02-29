package com.zhou.spring.philosophy.ioc.container.overview.dependency.domain;

import com.zhou.spring.philosophy.ioc.container.overview.dependency.annotation.Super;

/**
 * 超级用户
 * Created on 2020/2/29 7:17 下午
 *
 * @author <a href="cjzjava@gmail.com">zhouplus</a>
 * @version V1.0
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"address\":\"")
                .append(address).append('\"');
        sb.append("\"super\":\"")
                .append(super.toString()).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
