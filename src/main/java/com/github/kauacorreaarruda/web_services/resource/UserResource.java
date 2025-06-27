package com.github.kauacorreaarruda.web_services.resource;

import com.github.kauacorreaarruda.web_services.dto.user.UserCreateRequestDTO;
import com.github.kauacorreaarruda.web_services.dto.user.UserResponseDTO;
import com.github.kauacorreaarruda.web_services.dto.user.UserUpdateRequestDTO;
import com.github.kauacorreaarruda.web_services.entity.User;
import com.github.kauacorreaarruda.web_services.mapper.UserMapper;
import com.github.kauacorreaarruda.web_services.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserResource {

    private final UserService service;
    private final UserMapper mapper;

    public UserResource(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<User> insert(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        User user = service.insert(userCreateRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        User user = service.update(id, userUpdateRequestDTO);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserResponseDTO> dtoList = users.stream().map(mapper::mapEntityToDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(mapper.mapEntityToDTO(user));
    }
}
