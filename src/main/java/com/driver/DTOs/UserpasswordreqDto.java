package com.driver.DTOs;

public class UserpasswordreqDto {
    private int id;
    private String newpassword;

    public UserpasswordreqDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
