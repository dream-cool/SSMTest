package com.clt.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
    private String name;
    private Integer age;
    private String[] friends;
    private Map<String,User> users;


    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public List<Integer> numbers;

    public List<Dog> dogs;

    public Set<Dog> dogSet;

    public Map<String,Dog> dogMap;

    public Map<String, Dog> getDogMap() {
        return dogMap;
    }

    public void setDogMap(Map<String, Dog> dogMap) {
        this.dogMap = dogMap;
    }

    public Set<Dog> getDogSet() {
        return dogSet;
    }

    public void setDogSet(Set<Dog> dogSet) {
        this.dogSet = dogSet;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public People() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                ", numbers=" + numbers +
                ", dogs=" + dogs +
                ", dogSet=" + dogSet +
                ", dogMap=" + dogMap +
                '}';
    }
}
