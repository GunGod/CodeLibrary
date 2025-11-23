package org.annotation;

public class InitDemo {
    @InitMethod
    public void init() {
        System.out.println("waiting for init...");
    }

    public void test() {}
}
