package com.vthakkar;

import java.util.LinkedList;
/* CTCI 3.6 pg. 251*/
public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog)
            dogs.addLast((Dog) a);
        else if (a instanceof Cat)
            cats.addLast((Cat) a);
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCats();
        }
        if (cats.isEmpty()) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Animal peek() {
        if (dogs.isEmpty()) {
            return peekCats();
        }
        if (cats.isEmpty()) {
            return peekDogs();
        }
        Dog dog = peekDogs();
        Cat cat = peekCats();
        if (dog.isOlderThan(cat)) {
            return peekDogs();
        } else {
            return peekCats();
        }
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Dog peekDogs() {
        return dogs.peek();
    }

    public Cat peekCats() {
        return cats.peek();
    }
}
