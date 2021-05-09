package com.murray.mq.consumer.service;

import com.murray.mq.commons.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理Service
 *
 * @author Murray Law
 * @date 2021/5/6 13:26
 */

@Service
public class CancelOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderService.class);

    public void cancelOrder(Order order) {
        //TODO 实际项目中执行一系类取消订单操作
        LOGGER.info("已取消订单{}", order);
    }
}
