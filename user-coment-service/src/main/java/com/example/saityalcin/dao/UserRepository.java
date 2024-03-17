package com.example.saityalcin.dao;

import com.example.saityalcin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
