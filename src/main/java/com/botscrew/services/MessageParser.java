package com.botscrew.services;

import com.botscrew.models.messanger.Messaging;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface MessageParser {
    void parseMessage(Messaging messaging, Long sessionId) throws Exception;
}
