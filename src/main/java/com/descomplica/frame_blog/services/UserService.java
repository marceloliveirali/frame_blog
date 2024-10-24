package com.descomplica.frame_blog.services;

import com.descomplica.frame_blog.models.User;

import java.util.List;

public interface UserService {
    
    User save(User user);

    List<User> getAll();

    User get(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
