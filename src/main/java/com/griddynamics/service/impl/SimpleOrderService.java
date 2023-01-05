package com.griddynamics.service.impl;

import com.griddynamics.dao.IOrderDao;
import com.griddynamics.dao.ITariffDao;
import com.griddynamics.model.Order;
import com.griddynamics.service.IOrderService;

public class SimpleOrderService implements IOrderService {
    private final IOrderDao orderDao;

    private final ITariffDao tariffDao;

    public SimpleOrderService(IOrderDao orderDao, ITariffDao tariffDao) {
        this.orderDao = orderDao;
        this.tariffDao = tariffDao;
    }

    @Override
    public Order addOrder(Order order) {
        if (!tariffDao.tariffExists(order.getTariffId())) {
            throw new IllegalArgumentException("No such tariff");
        }
        return orderDao.save(order);
    }
}
