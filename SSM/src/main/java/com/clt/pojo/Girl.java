package com.clt.pojo;

public class Girl {
    private  String name;
    private  int age;

    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Girl() {

    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  void destory(){
        System.out.println("销毁");
    }

    public  void start(){
        System.out.println("初始化");
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
