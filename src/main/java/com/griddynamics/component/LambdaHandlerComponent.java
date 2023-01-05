package com.griddynamics.component;

import com.griddynamics.LambdaHandler;
import com.griddynamics.module.ConfigModule;
import com.griddynamics.module.DynamoDbClientModule;
import com.griddynamics.module.DynamoDbMapperModule;
import com.griddynamics.module.DynamoDbModule;
import com.griddynamics.module.OrderDaoModuleDynamo;
import com.griddynamics.module.OrderServiceModule;
import com.griddynamics.module.TariffDaoModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        OrderServiceModule.class,
        OrderDaoModuleDynamo.class,
        ConfigModule.class,
        DynamoDbClientModule.class,
        TariffDaoModule.class,
        DynamoDbModule.class,
        DynamoDbMapperModule.class})
public interface LambdaHandlerComponent {
    void inject(LambdaHandler lambdaHandler);
}
