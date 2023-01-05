package com.griddynamics.module;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DynamoDbModule {
    @Provides
    @Singleton
    public DynamoDB dynamoDB(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDB(amazonDynamoDB);
    }
}
