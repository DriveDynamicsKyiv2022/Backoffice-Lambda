package com.griddynamics.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.griddynamics.car.enums.CarBodyStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@DynamoDBTable(tableName = "orders")
public class Order {
    @JsonIgnore
    @DynamoDBIgnore
    public static final String userIdIndexName = "userId-index";
    @JsonProperty(value = "orderId")
    @DynamoDBHashKey
    private String orderId;

    @JsonProperty(value = "startDateTimestamp")
    @DynamoDBAttribute
    private Long startDateTimestamp;

    @JsonProperty(value = "endDateTimestamp")
    @DynamoDBAttribute
    private Long endDateTimestamp;

    @JsonProperty(value = "price")
    @DynamoDBAttribute
    private Double price;

    @JsonProperty(value = "userId")
    @DynamoDBIndexHashKey(attributeName = "userId", globalSecondaryIndexName = userIdIndexName)
    private Long userId;

    @JsonProperty(value = "carId")
    @DynamoDBAttribute
    private Long carId;

    @JsonProperty(value = "tariffId")
    @DynamoDBAttribute
    private String tariffId;

    @JsonProperty(value = "carBodyStyle")
    @DynamoDBTypeConvertedEnum
    private CarBodyStyle carBodyStyle;

}


