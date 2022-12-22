package com.griddynamics.module;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.griddynamics.dao.IOrderDao;
import com.griddynamics.dao.impl.OrderDaoDynamo;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class OrderDaoModuleDynamo {
    @Provides
    @Singleton
    public IOrderDao orderDao(DynamoDBMapper dynamoDBMapper) {
        return new OrderDaoDynamo(dynamoDBMapper);
    }
}
