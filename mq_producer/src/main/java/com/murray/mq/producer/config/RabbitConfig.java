package com.murray.mq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ配置类
 *
 * @author Murray
 * @date 2021/5/6 14:24
 */
@Configuration
public class RabbitConfig {

    /**
     * 订单延迟插件消息队列所绑定的交换机
     */
    @Bean
    CustomExchange orderPluginDirect() {
        //创建一个自定义交换机，可以发送延迟消息
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getExchange(), "x-delayed-message", true, false, args);
    }

    /**
     * 订单延迟插件队列
     */
    @Bean
    public Queue orderPluginQueue() {
        return new Queue(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getName());
    }

    /**
     * 将订单延迟插件队列绑定到交换机
     */
    @Bean
    public Binding orderPluginBinding(CustomExchange orderPluginDirect, Queue orderPluginQueue) {
        return BindingBuilder
                .bind(orderPluginQueue)
                .to(orderPluginDirect)
                .with(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getRouteKey())
                .noargs();
    }
    /**
     * 将默认的消息转换器替换成json消息转换器
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}