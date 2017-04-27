package com.botscrew.services.impl;

import com.botscrew.models.enums.messanger.PayloadType;
import com.botscrew.models.messanger.Messaging;
import com.botscrew.repositories.RoomDao;
import com.botscrew.services.MessageSenderService;
import com.botscrew.services.PayloadParser;
import com.botscrew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Den Boyko
 * @version 1.0
 */
@Service
public class PayloadParserImpl implements PayloadParser {

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private RoomDao roomDao;


    @Override
    public void parsePayload(Messaging messaging) throws Exception{
        String payload = messaging.getPostback().getPayload();
        switch (PayloadType.valueOf(payload.split("\\?")[0])){
            case GET_STARTED_PAYLOAD:{
                messageSenderService.sayHello(messaging.getSender().getId());
                break;
            }case NEXT_ROOMS:{
                messageSenderService.sendBookedRooms(messaging.getSender().getId(), Integer.parseInt(payload.split("\\?")[1]));
                break;
            }
            case DELETE:{
                roomDao.delete(Long.parseLong(payload.split("\\?")[1]));
                messageSenderService.sendBookedRooms(messaging.getSender().getId(),0);
                break;
            }
            default:{
                messageSenderService.sendErrorMessage(messaging.getSender().getId());
            }

        }


    }


}
