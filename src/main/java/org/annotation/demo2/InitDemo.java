package org.annotation.demo2;

public class InitDemo {
    @InitMethod
    public void init() {
        System.out.println("waiting for init...");
    }

    public void test() {}
}
