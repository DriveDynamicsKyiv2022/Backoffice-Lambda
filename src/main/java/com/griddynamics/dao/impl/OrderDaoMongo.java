package com.griddynamics.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.dao.IOrderDao;
import com.griddynamics.model.Order;
import com.griddynamics.util.OrderUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class OrderDaoMongo implements IOrderDao {
    MongoClient mongoClient;
    ObjectMapper objectMapper;
    MongoCollection<Document> collection;

    public OrderDaoMongo(MongoClient mongoClient, ObjectMapper objectMapper) {
        this.mongoClient = mongoClient;
        this.objectMapper = objectMapper;
        MongoDatabase mongoDatabase = mongoClient.getDatabase("backoffice_db");
        this.collection = mongoDatabase.getCollection("orders");
        System.out.println(collection);
    }

    @Override
    public Order save(Order order) {
        System.out.println("----accessing database");
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            Document orderDocument = Document.parse(orderJson);
            collection.insertOne(orderDocument);
            System.out.println("----all ok");
            return find(order.getOrderId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Couldn't save order");
        }
    }

    @Override
    public Order find(String id) {
        Document orderDocument = collection.find(Filters.eq("orderId", id)).first();
        if (orderDocument == null) {
            throw new RuntimeException("Couldn't find order");
        }
        return OrderUtil.parseOrderFromDocument(orderDocument, objectMapper);
    }

    @Override
    public Order update(Order order) {
        return null;
    }
}
