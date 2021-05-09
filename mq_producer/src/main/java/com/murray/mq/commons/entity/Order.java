package com.murray.mq.commons.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * 订单实体类
 *
 * @author Murray Law
 * @date 2021/5/8 14:30
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -8432910728496351007L;
    String orderNumber;
    String userName;
    Integer age;
    String remark;

    public Order() {
    }

    public Order(String userName, Integer age, String remark) {
        this.orderNumber = UUID.randomUUID().toString().trim().replaceAll("-", "");
        this.userName = userName;
        this.age = age;
        this.remark = remark;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }
}
