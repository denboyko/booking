package com.botscrew.repositories;

import com.botscrew.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Den Boyko
 * @version 1.0
 */

public interface UserDao extends JpaRepository<User, Long> {
}
