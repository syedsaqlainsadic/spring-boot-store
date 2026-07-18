package com.firstspringproject.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.firstspringproject.store.dto.RegisterUserRequest;
import com.firstspringproject.store.dto.UpdateUserRequest;
import com.firstspringproject.store.dto.UserDto;
import com.firstspringproject.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    UserDto tDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);

}
