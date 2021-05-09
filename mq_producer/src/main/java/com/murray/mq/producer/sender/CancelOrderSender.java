package com.murray.mq.producer.sender;

import com.murray.mq.producer.config.QueueEnum;
import com.murray.mq.commons.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单自动取消的消息发出者
 *
 * @author Murray Law
 * @date  2021/5/6 13:24
 */
@Component
public class CancelOrderSender {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Order order, final long delayTimes) {
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getExchange(), QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getRouteKey(), order, message -> {
            //给消息设置延迟毫秒值
            message.getMessageProperties().setHeader("x-delay", delayTimes);
            return message;
        });
        LOGGER.info("发送出了一个延时取消订单{}", order);
    }
}
