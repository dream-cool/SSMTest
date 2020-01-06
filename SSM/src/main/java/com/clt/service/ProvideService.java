package com.clt.service;

import com.clt.pojo.PrivderDao;

public class ProvideService {
    private PrivderDao privderDao;

    public ProvideService() {
    }

    public PrivderDao getPrivderDao() {
        return privderDao;
    }

    public void setPrivderDao(PrivderDao privderDao) {
        this.privderDao = privderDao;
    }

    public void add1(){
        System.out.println("方法1");
    }
    public void add2(int add){
        System.out.println("方法2");
    }
}
