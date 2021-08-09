package com.alvesgleibson.firebase_firstapp;

public class User {

    private String name, lastname, profession;
    private int age;
    private Eat eat;

    public User() {
    }

    public Eat getEat() {
        return eat;
    }

    public void setEat(Eat eat) {
        this.eat = eat;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
