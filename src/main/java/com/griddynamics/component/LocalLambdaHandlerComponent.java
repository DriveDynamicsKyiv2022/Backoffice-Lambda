package com.griddynamics.component;

import com.griddynamics.LambdaHandler;
import com.griddynamics.module.ConfigModule;
import com.griddynamics.module.LocalMongoClientModule;
import com.griddynamics.module.OrderDaoModule;
import com.griddynamics.module.OrderServiceModule;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        OrderServiceModule.class,
        OrderDaoModule.class,
        ConfigModule.class,
        LocalMongoClientModule.class
})
@Singleton
public interface LocalLambdaHandlerComponent {
    void inject(LambdaHandler lambdaHandler);
}
