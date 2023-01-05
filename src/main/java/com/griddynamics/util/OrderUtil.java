package com.griddynamics.util;

import com.griddynamics.model.Order;
import com.griddynamics.order.OrderDto;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import java.time.ZoneOffset;
import java.util.UUID;

public class OrderUtil {
    public static Order getEntity(@Valid OrderDto orderDto) {
        String orderId = getOrGenerateId(orderDto.getOrderId());
        return Order.builder()
                .orderId(orderId)
                .userId(orderDto.getUserId())
                .carId(orderDto.getCarId())
                .tariffId(orderDto.getTariffId())
                .carBodyStyle(orderDto.getCarBodyStyle())
                .endDateTimestamp(orderDto.getEndDateTime().toEpochSecond(ZoneOffset.UTC))
                .startDateTimestamp(orderDto.getStartDateTime().toEpochSecond(ZoneOffset.UTC))
                .build();
    }

    private static String getOrGenerateId(@Nullable String id) {
        return id == null ? UUID.randomUUID().toString() : id;
    }
}
