package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(User user){
        User user1=new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setFirstName("test");
        user1.setLastName("test");
        if(user.getFirstName()!=null){
            user1.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            user1.setLastName(user.getLastName());
        }
        userRepository3.save(user1);
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public void updateUser(User user)
    {
        User user1=userRepository3.findById(user.getId()).get();
        user1.setPassword(user.getPassword());
        userRepository3.save(user1);
    }

    public User findUserByUsername(String username)
    {
        return userRepository3.findByUsername(username);

    }
}
