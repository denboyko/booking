package com.botscrew.services.impl;

import com.botscrew.models.messanger.Messaging;
import com.botscrew.models.messanger.QuickReply;
import com.botscrew.services.MessageSenderService;
import com.botscrew.services.QuickReplyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Den Boyko
 * @version 1.0
 */
@Service
public class QuickReplyParserImpl implements QuickReplyParser {

    @Autowired
    private MessageSenderService messageSenderService;

    @Override
    public void parseQuickReply(Messaging messaging) {

        QuickReply quickReply = messaging.getMessage().getQuickReply();
        if(quickReply!=null){

        }
    }
}