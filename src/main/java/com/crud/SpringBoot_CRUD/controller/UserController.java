package com.crud.SpringBoot_CRUD.controller;
import com.crud.SpringBoot_CRUD.dto.UserDTO;
import com.crud.SpringBoot_CRUD.entity.User;
import com.crud.SpringBoot_CRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("success add user"); // Returning a ResponseEntity with a success message
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id , @RequestBody User user){
        userService.updateUser(id , user);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-name/{id}")
        public ResponseEntity<Void> updateName(@PathVariable Integer id , @RequestBody UserDTO userDTO){
        userService.updateName(id , userDTO);
        return ResponseEntity.noContent().build();


    }

        }














