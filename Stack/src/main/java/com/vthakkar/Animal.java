package com.vthakkar;

public abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) { this.order = order;}
    public int getOrder() {return this.order;}

    public boolean isOlderThan(Animal other) {return this.order < other.order;}
}
