package com.github.kauacorreaarruda.web_services.mapper;

import com.github.kauacorreaarruda.web_services.dto.user.UserCreateRequestDTO;
import com.github.kauacorreaarruda.web_services.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapDTOToEntity(final UserCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setPassword(dto.password());

        return user;
    }
}
