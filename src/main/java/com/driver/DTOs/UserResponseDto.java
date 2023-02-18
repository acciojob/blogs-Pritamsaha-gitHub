package com.driver.DTOs;

import com.driver.models.Blog;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDto {
    //private int id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;
    private List<Blog> blogList=new ArrayList<>();

    public UserResponseDto() {
    }

    public UserResponseDto(String username, String password, String firstName, String lastName, List<Blog> blogList) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogList = blogList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
