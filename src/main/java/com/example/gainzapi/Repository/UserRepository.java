package com.example.gainzapi.Repository;

import com.example.gainzapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
