package org.alejo.mapper;

import org.alejo.dto.UserDTO;
import org.alejo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}