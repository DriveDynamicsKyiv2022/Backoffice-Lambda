package com.griddynamics;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.component.DaggerLambdaHandlerComponent;
import com.griddynamics.component.DaggerLocalLambdaHandlerComponent;
import com.griddynamics.model.Order;
import com.griddynamics.order.OrderDto;
import com.griddynamics.service.IOrderService;
import com.griddynamics.util.OrderUtil;

import javax.inject.Inject;

public class LambdaHandler implements RequestHandler<SQSEvent, Void> {
    @Inject
    IOrderService orderService;

    @Inject
    ObjectMapper objectMapper;

    public LambdaHandler() {
        System.out.println("----start");
        String env = System.getProperty("env");
        if (env != null && env.equalsIgnoreCase("local")) {
            DaggerLocalLambdaHandlerComponent.create().inject(this);
        } else {
            DaggerLambdaHandlerComponent.create().inject(this);
        }
    }

    @Override
    public Void handleRequest(SQSEvent sqsEvent, Context context) {
        String messageBody = sqsEvent.getRecords().get(0).getBody();
        OrderDto orderDto;
        try {
            System.out.println("----body: " + messageBody);
            orderDto = objectMapper.readValue(messageBody, OrderDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Order order = OrderUtil.getEntity(orderDto);
        order = orderService.addOrder(order);
        System.out.println(order.getTariffId());
        return null;
    }

}
