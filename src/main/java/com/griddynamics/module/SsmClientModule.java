package com.griddynamics.module;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class SsmClientModule {
    @Provides
    @Singleton
    public AWSSimpleSystemsManagement ssmClient() {
        System.out.println("----building ssm client");
        return AWSSimpleSystemsManagementClientBuilder.defaultClient();
    }
}
