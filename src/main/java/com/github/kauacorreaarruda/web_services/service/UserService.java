package com.github.kauacorreaarruda.web_services.service;

import com.github.kauacorreaarruda.web_services.dto.user.UserCreateRequestDTO;
import com.github.kauacorreaarruda.web_services.dto.user.UserUpdateRequestDTO;
import com.github.kauacorreaarruda.web_services.entity.User;
import com.github.kauacorreaarruda.web_services.mapper.UserMapper;
import com.github.kauacorreaarruda.web_services.repository.UserRepository;
import com.github.kauacorreaarruda.web_services.service.exception.DatabaseException;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User insert(UserCreateRequestDTO userCreateRequestDTO) {
        User user = mapper.mapDTOToEntityCreate(userCreateRequestDTO);
        return repository.save(user);
    }

    public User update(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        try {
            User user = repository.getReferenceById(id);
            mapper.mapDTOToEntityUpdate(userUpdateRequestDTO);
            return repository.save(user);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
