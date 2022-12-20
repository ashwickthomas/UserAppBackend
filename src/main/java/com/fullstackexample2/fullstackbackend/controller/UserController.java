package com.fullstackexample2.fullstackbackend.controller;


import com.fullstackexample2.fullstackbackend.exception.UserNotFoundException;
import com.fullstackexample2.fullstackbackend.model.User;
import com.fullstackexample2.fullstackbackend.repository.UerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UerRepository userRepository;

    @PostMapping("/AddUser")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/getUsers")
            public ResponseEntity<List<User>>getAllUsers()
    {
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.FOUND);

    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException {
         return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id)
    {
        return userRepository.findById(id)
                .map((us)-> {

                    us.setUserName(user.getUserName());
                    us.setName(user.getName());
                    us.setEmail(user.getEmail());
                    return userRepository.save(us);
                }).get();
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id)
    {

        if(!userRepository.existsById(id))
        {
            throw new UserNotFoundException(id);
        }

   // userRepository.findAll().remove(userRepository.findById(id));
        userRepository.deleteById(id);
        return "User with id" +id +" "+ "is deleted";
    }


}
