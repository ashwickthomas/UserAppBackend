package com.fullstackexample2.fullstackbackend.repository;

import com.fullstackexample2.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UerRepository extends JpaRepository<User, Long> {
}
