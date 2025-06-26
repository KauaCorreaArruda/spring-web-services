package com.github.kauacorreaarruda.web_services.service;

import com.github.kauacorreaarruda.web_services.dto.user.UserCreateRequestDTO;
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

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(UserCreateRequestDTO userCreateRequestDTO) {
        User user = mapper.mapDTOToEntity(userCreateRequestDTO);
        return repository.save(user);
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

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
