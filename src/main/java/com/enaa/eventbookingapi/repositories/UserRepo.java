package com.enaa.eventbookingapi.repositories;

import com.enaa.eventbookingapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
    User findUserById(Long id);
}
