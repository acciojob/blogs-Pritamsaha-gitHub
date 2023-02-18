package com.driver.services;

import com.driver.DTOs.UserpasswordreqDto;
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
        userRepository3.save(user);
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public void updateUser(UserpasswordreqDto user)
    {
        User user1=userRepository3.findById(user.getId()).get();

        user1.setPassword(user.getNewpassword());
        userRepository3.save(user1);
    }

    public User findUserByUsername (String username)
    {
//        User user= userRepository3.findByUsername(username);
//        UserResponseDto userResponseDto=new UserResponseDto();
//        userResponseDto.setFirstName(user.getFirstName());
//        userResponseDto.setLastName(user.getLastName());
//        userResponseDto.setUsername(user.getUsername());
//        userResponseDto.setPassword(user.getPassword());
//        List<Blog>currentList=user.getBlogList();
//        userResponseDto.setBlogList(currentList);
//        return userResponseDto;
        return userRepository3.findByUsername(username);
    }
}
