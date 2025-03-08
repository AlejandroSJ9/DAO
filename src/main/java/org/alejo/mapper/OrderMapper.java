package org.alejo.mapper;

import org.alejo.dto.OrderDTO;
import org.alejo.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "localDateTimeToTimestamp")
    OrderDTO toDTO(Order order);

    @Mapping(source = "orderDate", target = "orderDate", qualifiedByName = "timestampToLocalDateTime")
    Order toEntity(OrderDTO orderDTO);

    @Named("localDateTimeToTimestamp")
    static Timestamp localDateTimeToTimestamp(LocalDateTime dateTime) {
        return (dateTime != null) ? Timestamp.valueOf(dateTime) : null;
    }

    @Named("timestampToLocalDateTime")
    static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
        return (timestamp != null) ? timestamp.toLocalDateTime() : null;
    }
}
