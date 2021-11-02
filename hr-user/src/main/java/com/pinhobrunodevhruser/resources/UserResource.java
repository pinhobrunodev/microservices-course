package com.pinhobrunodevhruser.resources;

import com.pinhobrunodevhruser.dto.UserDTO;
import com.pinhobrunodevhruser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserService service;



    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping(value = "/search")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(service.findByEmail(email));
    }
}
