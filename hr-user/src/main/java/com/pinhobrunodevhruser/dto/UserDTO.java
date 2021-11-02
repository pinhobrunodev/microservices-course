package com.pinhobrunodevhruser.dto;

import com.pinhobrunodevhruser.entities.User;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private List<RoleDTO> roles = new ArrayList<>();

    public UserDTO(){

    }


    public UserDTO(User entity){
    id = entity.getId();
    name = entity.getName();
    password = entity.getPassword();
    email = entity.getEmail();
    entity.getRoles().forEach(x->roles.add(new RoleDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }
}
