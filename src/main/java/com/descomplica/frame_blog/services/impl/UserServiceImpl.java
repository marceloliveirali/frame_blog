package com.descomplica.frame_blog.services.impl;

import java.util.Objects;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.frame_blog.models.User;
import com.descomplica.frame_blog.repositories.UserRepository;
import com.descomplica.frame_blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
   
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {

        User extingUser = userRepository.findByUsername(user.getName());

        if(Objects.nonNull(extingUser)) {
            throw new RuntimeErrorException("Existing User");
        }

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassworld(), user.getRole());
        User newUser = userRepository.save(entity);

        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassworld(), newUser.getRole());
    }
}
