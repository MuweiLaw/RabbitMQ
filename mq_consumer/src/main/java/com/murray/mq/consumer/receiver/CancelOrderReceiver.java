package com.murray.mq.consumer.receiver;

import com.murray.mq.commons.entity.Order;
import com.murray.mq.consumer.service.CancelOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单自动取消的消息接受者
 *
 * @author Murray Law
 * @date 2021/5/6 13:23
 */
@Component
@RabbitListener(queues = "mall.order.cancel.plugin")
public class CancelOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private CancelOrderService portalOrderService;

    @RabbitHandler
    public void handle(Order order) {
        LOGGER.info("接受到一个订单因超时未支付{}", order);
        portalOrderService.cancelOrder(order);
    }
}
