package com.griddynamics.module;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.griddynamics.dao.ITariffDao;
import com.griddynamics.dao.impl.TariffDaoDynamo;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class TariffDaoModule {
    @Provides
    @Singleton
    public ITariffDao tariffDao(DynamoDB dynamoDB) {
        return new TariffDaoDynamo(dynamoDB);
    }
}
