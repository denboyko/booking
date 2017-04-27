package com.botscrew.services.impl;

import com.botscrew.models.messanger.Entry;
import com.botscrew.models.messanger.Event;
import com.botscrew.models.messanger.Messaging;
import com.botscrew.services.EventParser;
import com.botscrew.services.MessageParser;
import com.botscrew.services.MessageSenderService;
import com.botscrew.services.PayloadParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

@Service
public class EventParserImpl implements EventParser {

    @Autowired
    private MessageParser messageParser;

    @Autowired
    private PayloadParser payloadParser;

    @Autowired
    private MessageSenderService messageSenderService;

    @Override
    public void parseEvent(Event event) {

        List<Entry> entries  = event.getEntry();

        for (Entry entry: entries) {
                List<Messaging> messagings = entry.getMessaging();
                for (Messaging mes : messagings) {
                    try {
                        if (mes.getPostback() != null) {
                            payloadParser.parsePayload(mes);
                        } else if (mes.getMessage() != null) {
                            if (mes.getMessage().getAttachment() != null) {
                                messageSenderService.sendErrorMessage(mes.getSender().getId());
                            }
                            messageParser.parseMessage(mes, entry.getId());
                        }
                    }catch (Exception ex){
                        messageSenderService.sendErrorMessage(mes.getSender().getId());
                }
        }

        }
    }
}