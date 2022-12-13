package com.griddynamics.module;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LocalMongoClientModule {
    @Provides
    @Singleton
    public MongoClient mongoClient() {
        AWSSimpleSystemsManagementClientBuilder standard = AWSSimpleSystemsManagementClientBuilder.standard();
        standard.setRegion("eu-central-1");
        standard.setCredentials(new EnvironmentVariableCredentialsProvider());
        AWSSimpleSystemsManagement client = standard.build();
        GetParameterRequest request = new GetParameterRequest();
        request.setName("backoffice-db-uri");
        request.withWithDecryption(true);
        String dbUri = client.getParameter(request).getParameter().getValue();
        System.out.println(dbUri);
        return new MongoClient(new MongoClientURI(dbUri));
    }
}
