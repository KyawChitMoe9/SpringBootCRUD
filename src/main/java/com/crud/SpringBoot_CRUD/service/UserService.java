package com.crud.SpringBoot_CRUD.service;
import com.crud.SpringBoot_CRUD.dto.UserDTO;
import com.crud.SpringBoot_CRUD.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUser();


    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);

}
