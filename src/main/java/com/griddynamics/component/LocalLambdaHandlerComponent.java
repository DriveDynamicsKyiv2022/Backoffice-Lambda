package com.griddynamics.component;

import com.griddynamics.LambdaHandler;
import com.griddynamics.module.ConfigModule;
import com.griddynamics.module.DynamoDbMapperModule;
import com.griddynamics.module.DynamoDbModule;
import com.griddynamics.module.LocalDynamoDbClientModule;
import com.griddynamics.module.OrderDaoModuleDynamo;
import com.griddynamics.module.OrderServiceModule;
import com.griddynamics.module.TariffDaoModule;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        OrderServiceModule.class,
        OrderDaoModuleDynamo.class,
        DynamoDbMapperModule.class,
        LocalDynamoDbClientModule.class,
        TariffDaoModule.class,
        DynamoDbModule.class,
        ConfigModule.class,
})
@Singleton
public interface LocalLambdaHandlerComponent {
    void inject(LambdaHandler lambdaHandler);
}
