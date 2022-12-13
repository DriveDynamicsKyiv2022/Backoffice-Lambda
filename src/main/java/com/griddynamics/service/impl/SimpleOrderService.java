package com.griddynamics.service.impl;

import com.griddynamics.dao.IOrderDao;
import com.griddynamics.model.Order;
import com.griddynamics.service.IOrderService;

public class SimpleOrderService implements IOrderService {
    IOrderDao orderDao;

    public SimpleOrderService(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }
}
