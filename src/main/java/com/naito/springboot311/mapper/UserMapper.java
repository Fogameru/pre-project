package com.naito.springboot311.mapper;

import com.naito.springboot311.model.User;
import com.naito.springboot311.model.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    UserDto toDto(User user);

    List<UserDto> toDtos(List<User> users);

    @Mapping(target = "id", source = "id")
    User toUser(UserDto user);
}
