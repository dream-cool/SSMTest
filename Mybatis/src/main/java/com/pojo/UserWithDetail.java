package com.pojo;

public class UserWithDetail extends  User {
    private  UserDetail userDetail;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + getuId() +
                ", tel='" + getTel() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", createtime=" + getCreatetime() +
                ", States=" + getStates() +
                '}'+"UserWithDetail{" +
                "userDetail=" + userDetail +
                '}';
    }
}
