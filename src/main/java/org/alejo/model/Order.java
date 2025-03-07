package org.alejo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private LocalDateTime orderDate;
}
