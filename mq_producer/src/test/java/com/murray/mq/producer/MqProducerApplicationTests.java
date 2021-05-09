package com.murray.mq.producer;

import com.murray.mq.commons.entity.Order;
import com.murray.mq.producer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqProducerApplicationTests {
    @Autowired
   public OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void generateOrder() {
        Order order = new Order("罗世平", 18, "老子想白嫖！！！");
        orderService.generateOrder(order);
    }
}
