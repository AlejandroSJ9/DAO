package org.alejo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private LocalDateTime orderDate;
}
