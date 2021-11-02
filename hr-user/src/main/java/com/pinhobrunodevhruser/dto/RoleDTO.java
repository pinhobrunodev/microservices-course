package com.pinhobrunodevhruser.dto;

import com.pinhobrunodevhruser.entities.Role;

public class RoleDTO {
    private Long id;
    private String roleName;


    public RoleDTO() {
    }

    public RoleDTO(Role entity) {
        id = entity.getId();
        roleName = entity.getRoleName();
    }

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
