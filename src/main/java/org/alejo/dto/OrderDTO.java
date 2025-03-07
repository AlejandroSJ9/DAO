package org.alejo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private Integer quantity;
    private LocalDateTime orderDate;
}
