package com.botscrew.services;

import com.botscrew.models.messanger.Messaging;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface PayloadParser {
    void parsePayload(Messaging messaging) throws Exception;
}
