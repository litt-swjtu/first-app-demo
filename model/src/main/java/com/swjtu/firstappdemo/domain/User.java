package com.swjtu.firstappdemo.domain;

/**
 * User Model
 * @author 李天峒
 * @date 2019/5/29 0:05
 */
public class User {

    /**
     * 用户id
     */
    private int id;

    /**
     * 用户姓名
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
