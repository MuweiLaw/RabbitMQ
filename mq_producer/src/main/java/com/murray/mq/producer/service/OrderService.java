package com.murray.mq.producer.service;

import com.murray.mq.commons.entity.Order;
import com.murray.mq.producer.sender.CancelOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理Service
 *
 * @author Murray Law
 * @date 2021/5/6 13:26
 */

@Service
public class OrderService {

    @Autowired
    private CancelOrderSender cancelOrderSender;

    public void generateOrder(Order order) {
        //TODO 实际项目中会执行一系类下单操作
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单
        sendDelayMessageCancelOrder(order);
    }

    private void sendDelayMessageCancelOrder(Order order) {
        //获取订单超时时间，假设为60分钟(测试用的10秒)
        long delayTimes = 10 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(order, delayTimes);
    }
}
