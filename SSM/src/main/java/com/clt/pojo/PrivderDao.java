package com.clt.pojo;

public class PrivderDao {

    private  String url;
    private String  driver;
    private String root;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  void update(){
        System.out.println("xiugai");
    }

    @Override
    public String toString() {
        return "PrivderDao{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", root='" + root + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
