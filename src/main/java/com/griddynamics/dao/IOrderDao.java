package com.griddynamics.dao;

import com.griddynamics.model.Order;

public interface IOrderDao {
    Order save(Order order);
    Order update(Order order);

    Order find(String id);
}
