package com.crud.SpringBoot_CRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private  int id;

        private String name;

        private Integer age;

        private String address;



}
