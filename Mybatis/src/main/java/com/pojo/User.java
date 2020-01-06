package com.pojo;

import java.util.Date;
import java.util.List;

public class User {
    private Integer uId;

    private  String tel;

    private String password;

    private Date createtime;

    private Integer States;

    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public User() {
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStates() {
        return States;
    }

    public void setStates(Integer states) {
        States = states;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", createtime=" + createtime +
                ", States=" + States +
                '}';
    }
}
