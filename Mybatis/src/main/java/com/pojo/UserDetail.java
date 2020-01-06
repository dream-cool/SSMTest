package com.pojo;

public class UserDetail  {

    private  Integer udId;

    private  User user;

    private  String address;

    private  String  cid;

    public UserDetail() {
    }

    public Integer getUdId() {
        return udId;
    }

    public void setUdId(Integer udId) {
        this.udId = udId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "udId=" + udId +
                ", address='" + address + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
