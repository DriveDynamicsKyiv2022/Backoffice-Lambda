package com.griddynamics.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.backoffice.dto.OrderDto;
import com.griddynamics.model.Order;
import org.bson.Document;
import org.springframework.lang.Nullable;

import java.util.UUID;

public class OrderUtil {
    public static Order parseOrderFromDocument(Document document, ObjectMapper objectMapper) {
        document.remove("_id");
        document.remove("_class");
        try {
            return objectMapper.readValue(document.toJson(), Order.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Order getEntity(OrderDto orderDto) {
        String orderId = getOrGenerateId(orderDto.getOrderId());
        return Order.builder()
                .orderId(orderId)
                .carId(orderDto.getCarId())
                .startDateTime(orderDto.getStartDateTime())
                .endDateTime(orderDto.getEndDateTime())
                .price(orderDto.getPrice())
                .tariffId(orderDto.getTariffId())
                .userId(orderDto.getUserId())
                .build();
    }

    private static String getOrGenerateId(@Nullable String id) {
        return id == null ? UUID.randomUUID().toString() : id;
    }
}
