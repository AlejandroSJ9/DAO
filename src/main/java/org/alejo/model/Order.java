package org.alejo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private Integer quantity;
    private LocalDateTime orderDate;
}
