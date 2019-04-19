package com.example.demo.web;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;


    // curl -H "Content-Type: application/json" -X POST -d '{"firstName":"BR", "lastName":"AHN"}' http://localhost:8080/save
    @RequestMapping("/save")
    public String save(@RequestBody User user) throws Exception {

        System.out.println(userRepository.save(user));

        return "insert Test";
    }

    // curl -H "Content-Type: application/json" -X GET http://localhost:8080/findall
    @RequestMapping("/findall")
    public List<User> findall() throws Exception {

        List<User> customerList = userRepository.findAll();

        return customerList;
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"firstName":"BR", "lastName":"AHN"}' http://localhost:8080/findby
    @RequestMapping("/findby")
    public List<User> findby(@RequestBody User user) throws Exception {

        List<User> customerList = userRepository.findByLastName(user.getLastName());
        return customerList;
    }


    // curl -H "Content-Type: application/json" -X POST -d '{"id":"1", "firstName":"BR", "lastName":"AHN"}' http://localhost:8080/delete
    @RequestMapping("/delete")
    public String delete (@RequestBody User user) throws Exception {
        userRepository.delete(user);

        return "delete Test";
    }
    

}