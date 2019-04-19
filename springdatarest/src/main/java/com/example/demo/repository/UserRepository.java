package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    // curl -H "Content-Type: application/json" -X GET http://localhost:8080/users
    // curl -H "Content-Type: application/json" -X GET http://localhost:8080/users/2
    // curl -H "Content-Type: application/json" -X POST -d '{"firstName":"BR", "lastName":"AHN"}' http://localhost:8080/users
    // curl -H "Content-Type: application/json" -X PUT -d '{"firstName":"KD", "lastName":"HONG"}' http://localhost:8080/users/1
    // curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/3

    List<User> findByLastName(String lastName);
}
