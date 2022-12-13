package com.griddynamics.module;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class MongoClientModule {
    @Provides
    @Singleton
    public MongoClient mongoClient(AWSSimpleSystemsManagement ssmClient) {
        System.out.println("----getting db uri");
        GetParameterRequest parameterRequest = new GetParameterRequest();
        parameterRequest.withWithDecryption(true);
        parameterRequest.setName("backoffice-db-uri");
        String dbUri = ssmClient.getParameter(parameterRequest).getParameter().getValue();
        System.out.println("------all ok");
        System.out.println("-----" + dbUri);
        return new MongoClient(new MongoClientURI(dbUri));
    }
}
