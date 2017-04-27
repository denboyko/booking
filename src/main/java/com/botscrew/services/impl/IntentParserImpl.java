package com.botscrew.services.impl;

import com.botscrew.models.apiai.Result;
import com.botscrew.models.entities.Room;
import com.botscrew.models.entities.User;
import com.botscrew.models.enums.apiai.Intent;
import com.botscrew.repositories.RoomDao;
import com.botscrew.services.IntentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Den Boyko
 * @version 1.0
 */
@Service
public class IntentParserImpl implements IntentParser {


    @Autowired
    private RoomDao roomDao;

    @Override
    public void parseIntent(Result result, User user) {
        switch (Intent.valueOf(result.getMetadata().getIntentName())){
            case book:{
                Room room = new Room();
                room.setRoomSize(Integer.parseInt(result.getParameters().get("roomSize")));
                room.setLocation(result.getParameters().get("location"));
                room.setNights(Integer.parseInt(result.getParameters().get("nights")));
                room.setDate(result.getParameters().get("date"));
                room.setOwner(user);
                roomDao.saveAndFlush(room);
            }
        }
    }

    @Override
    public void parseIntent(ai.api.model.Result result, User user) {
        switch (Intent.valueOf(result.getMetadata().getIntentName())){
            case book:{
                Room room = new Room();
                room.setRoomSize(result.getParameters().get("roomSize").getAsInt());
                room.setLocation(result.getParameters().get("location").getAsString());
                room.setNights(result.getParameters().get("nights").getAsInt());
                room.setDate(result.getParameters().get("date").getAsString());
                room.setOwner(user);
                roomDao.saveAndFlush(room);

            }
        }
    }
}
