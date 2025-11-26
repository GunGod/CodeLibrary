package org.annotation.demo1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class OrderService {

    private static final Map<String, Order> orders = new HashMap<>();
    private static final Log log = LogFactory.getLog(OrderService.class);

    @ExecuteTime("创建订单")
    public Order createOrder(String orderId) {
        Order order = new Order();
        try {
            // 模拟业务处理
            Thread.sleep(2000L);
            order.setOrderId(orderId);
            order.setOrderName("测试订单");
            order.setOrderDesc("测试订单描述");
            orders.put(order.getOrderId(), order);
        } catch (Exception exception) {
            log.error("创建订单异常", exception);
        }
        return order;
    }

    @ExecuteTime("查询订单")
    public Order queryOrder(String orderId) {
        Order order = orders.get(orderId);
        try {
            // 模拟业务处理
            Thread.sleep(1000L);
            if (Objects.isNull(order)) {
                System.out.println("订单不存在");
                return null;
            }
        } catch (InterruptedException e) {
            log.error("查询订单异常", e);
        }
        return order;
    }
}
