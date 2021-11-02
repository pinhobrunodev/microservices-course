package com.pinhobrunodevhruser.services;

import com.pinhobrunodevhruser.dto.UserDTO;
import com.pinhobrunodevhruser.entities.User;
import com.pinhobrunodevhruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User user = repository.findById(id).get();
        return new UserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email){
        return new UserDTO(repository.findByEmail(email));
    }

}
