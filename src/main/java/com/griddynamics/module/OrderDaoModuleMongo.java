package com.griddynamics.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.dao.IOrderDao;
import com.griddynamics.dao.impl.OrderDaoMongo;
import com.mongodb.MongoClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class OrderDaoModuleMongo {
    @Provides
    @Singleton
    public IOrderDao orderDao(MongoClient mongoClient, ObjectMapper objectMapper) {
        return new OrderDaoMongo(mongoClient, objectMapper);
    }
}
