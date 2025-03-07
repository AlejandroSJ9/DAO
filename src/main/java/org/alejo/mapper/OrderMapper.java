package org.alejo.mapper;

import org.alejo.dto.OrderDTO;
import org.alejo.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDto(Order order);
    Order toEntity(OrderDTO dto);
}
