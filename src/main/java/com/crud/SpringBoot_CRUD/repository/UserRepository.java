package com.crud.SpringBoot_CRUD.repository;

import com.crud.SpringBoot_CRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
