package com.github.kauacorreaarruda.web_services.mapper;

import com.github.kauacorreaarruda.web_services.dto.user.UserCreateRequestDTO;
import com.github.kauacorreaarruda.web_services.dto.user.UserResponseDTO;
import com.github.kauacorreaarruda.web_services.dto.user.UserUpdateRequestDTO;
import com.github.kauacorreaarruda.web_services.entity.User;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapDTOToEntityCreate(final UserCreateRequestDTO dto) {
        if (dto == null) {
            throw new ResourceNotFoundException("UserCreateRequestDTO can't be null");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setPassword(dto.password());

        return user;
    }

    public void mapDTOToEntityUpdate(final UserUpdateRequestDTO dto, User user) {
        if (dto == null || user == null) {
            throw new ResourceNotFoundException("User and DTO can't be null");
        }

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
    }

    public UserResponseDTO mapEntityToDTO(final User user) {
        if (user == null) {
            throw new ResourceNotFoundException("User can't be null");
        }

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}
