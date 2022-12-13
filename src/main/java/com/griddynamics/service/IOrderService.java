package com.griddynamics.service;

import com.griddynamics.model.Order;

public interface IOrderService {
    Order addOrder(Order order);

    Order updateOrder(Order order);
}
