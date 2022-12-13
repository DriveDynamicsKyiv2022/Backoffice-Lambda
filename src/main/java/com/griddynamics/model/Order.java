package com.griddynamics.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Order {
    private String orderId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Double price;
    private Long userId;
    private Long carId;
    private String tariffId;
}

