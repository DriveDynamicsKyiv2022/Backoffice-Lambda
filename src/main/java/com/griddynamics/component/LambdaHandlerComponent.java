package com.griddynamics.component;

import com.griddynamics.LambdaHandler;
import com.griddynamics.module.ConfigModule;
import com.griddynamics.module.MongoClientModule;
import com.griddynamics.module.OrderDaoModuleMongo;
import com.griddynamics.module.OrderServiceModule;
import com.griddynamics.module.SsmClientModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        OrderServiceModule.class,
        OrderDaoModuleMongo.class,
        ConfigModule.class,
        MongoClientModule.class,
        SsmClientModule.class})
public interface LambdaHandlerComponent {
    void inject(LambdaHandler lambdaHandler);
}
