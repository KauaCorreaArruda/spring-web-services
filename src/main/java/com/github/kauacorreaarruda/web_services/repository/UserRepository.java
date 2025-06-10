package com.github.kauacorreaarruda.web_services.repository;

import com.github.kauacorreaarruda.web_services.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
