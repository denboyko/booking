package com.botscrew.repositories;

import com.botscrew.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface RoomDao extends JpaRepository<Room, Long> {
}
