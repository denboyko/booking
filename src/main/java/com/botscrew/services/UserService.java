package com.botscrew.services;

import com.botscrew.models.entities.User;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface UserService {
    User getUser(Long id);
    void updateUser(User user);
}
