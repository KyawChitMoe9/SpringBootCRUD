package com.crud.SpringBoot_CRUD.service;

import com.crud.SpringBoot_CRUD.dto.UserDTO;
import com.crud.SpringBoot_CRUD.entity.User;
import com.crud.SpringBoot_CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" +id));
        return user;

    }

    @Override
    public void updateUser(Integer id, User user) {
        //check weather the user is in database or not
        userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "Invalid user id" + id));
        user.setId(id);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id: " + id));

        user.setName(userDTO.getName()); // getName() method ကို parentheses ထည့်ထားတာ သေချာပါစေ
        userRepository.save(user); // ပြောင်းလဲထားတဲ့ user ကို save ပြန်လုပ်ပေးခြင်း
    }


}

