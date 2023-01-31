package com.griddynamics;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.component.DaggerLambdaHandlerComponent;
import com.griddynamics.component.DaggerLocalLambdaHandlerComponent;
import com.griddynamics.model.Order;
import com.griddynamics.order.OrderDto;
import com.griddynamics.service.IOrderService;
import com.griddynamics.util.OrderUtil;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LambdaHandler implements RequestStreamHandler {
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
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        System.out.println("----handling request");
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = inputStream.read()) != -1; ) {
            sb.append((char) ch);
        }
        System.out.println(sb);
        OrderDto orderDto = objectMapper.readValue(inputStream, OrderDto.class);
        Order order = OrderUtil.getEntity(orderDto);
        order = orderService.addOrder(order);
        System.out.println(order.getTariffId());
    }
}
