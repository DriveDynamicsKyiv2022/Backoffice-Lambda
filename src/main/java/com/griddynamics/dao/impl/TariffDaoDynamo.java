package com.griddynamics.dao.impl;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.griddynamics.dao.ITariffDao;

public class TariffDaoDynamo implements ITariffDao {
    private final DynamoDB dynamoDB;

    public TariffDaoDynamo(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    @Override
    public boolean tariffExists(String tariffId) {
        System.out.println("-----tariffId: " + tariffId);
        Item tariff = dynamoDB.getTable("tariffs").getItem("tariffId", tariffId);
        return tariff != null;
    }
}
