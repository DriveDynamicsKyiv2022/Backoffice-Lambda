package com.griddynamics.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.griddynamics.dao.IOrderDao;
import com.griddynamics.model.Order;

public class OrderDaoDynamo implements IOrderDao {
    private final DynamoDBMapper dynamoDBMapper;

    public OrderDaoDynamo(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Order save(Order order) {
        dynamoDBMapper.save(order);
        return find(order.getOrderId());
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order find(String id) {
        Order order = dynamoDBMapper.load(Order.class, id);
        if(order == null) {
            throw new IllegalArgumentException("No such tariff");
        }
        return order;
    }
}
