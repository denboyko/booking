package com.botscrew.services;

import com.botscrew.models.messanger.Messaging;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface MessageSenderService {
    void sayHello(Long recipient);
    void sendErrorMessage(Long recipient);
    void sendMessaging(Messaging messaging);
}
