package com.botscrew.services.impl;

import com.botscrew.models.enums.messanger.PayloadType;
import com.botscrew.models.messanger.Messaging;
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
    private UserService userService;


    @Override
    public void parsePayload(Messaging messaging) throws Exception{
        String payload = messaging.getPostback().getPayload();
        switch (PayloadType.valueOf(payload.split("\\?")[0])){
            case GET_STARTED_PAYLOAD:{
                messageSenderService.sayHello(messaging.getSender().getId());
                break;
            }
            default:{
                messageSenderService.sendErrorMessage(messaging.getSender().getId());
            }

        }


    }


}
