package org.annotation.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.annotation.demo1")
@EnableAspectJAutoProxy
public class ExecuteTimeTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExecuteTimeTest.class);
        OrderService orderService = context.getBean(OrderService.class);
        Order order = orderService.createOrder("订单1");
        Order order1 = orderService.queryOrder("订单2");
    }
}
