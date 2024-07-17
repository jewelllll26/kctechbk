package com.kctech.kctechbk.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kctech.kctechbk.Model.User;
import com.kctech.kctechbk.NotFoundException.UserNotFoundException;
import com.kctech.kctechbk.Repository.UserRepository;



@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new UserNotFoundException(id)
        );

    }

    @PostMapping("/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "A new user is created.";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            return repo.save(user);
        }).orElseGet(() -> {
            return repo.save(newUser);
        });

    }

    @DeleteMapping("delete/{id}")
    public String deleteUser (@PathVariable Long id){
        repo.deleteById(id);
        return "The user is deleted.";
    }


}