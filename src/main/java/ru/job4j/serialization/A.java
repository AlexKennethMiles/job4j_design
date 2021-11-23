package ru.job4j.serialization;

import org.json.JSONPropertyIgnore;

public class A {
    private B b;

    public A() {
    }

    @JSONPropertyIgnore
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String sayHello() {
        return "Hello";
    }
}
