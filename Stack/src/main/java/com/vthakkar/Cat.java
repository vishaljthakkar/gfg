package com.vthakkar;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String name() {
        return "Cat: " + name;
    }
}
