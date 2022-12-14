package com.griddynamics.module;

import com.griddynamics.dao.IOrderDao;
import com.griddynamics.service.IOrderService;
import com.griddynamics.service.impl.SimpleOrderService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class OrderServiceModule {
    @Provides
    @Singleton
    public IOrderService orderService(IOrderDao orderDao) {
        return new SimpleOrderService(orderDao);
    }
}
