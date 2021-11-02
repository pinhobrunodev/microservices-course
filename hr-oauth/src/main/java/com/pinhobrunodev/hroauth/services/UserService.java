package com.pinhobrunodev.hroauth.services;

import com.pinhobrunodev.hroauth.entities.User;
import com.pinhobrunodev.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient feignClient;

    public User findByEmail(String email){
        User user = feignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("User not found : "+email);
            throw  new IllegalArgumentException("Email not found");
        }
        logger.info("User found : "+email);
        return user;
    }


}
