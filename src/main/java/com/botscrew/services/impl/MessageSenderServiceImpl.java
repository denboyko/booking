package com.botscrew.services.impl;


import com.botscrew.models.messanger.*;
import com.botscrew.services.MessageSenderService;
import com.botscrew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @author Den Boyko
 * @version 1.0
 */

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    @Autowired
    private UserService userService;

    @Value("${page.access.token}")
    private String PAGE_ACCESS_TOKEN;

    @Value("${facebook.messages.url}")
    private String FACEBOOK_MESSAGES_URL;

    @Override
    public void sayHello(Long  recipient) {
        String username = userService.getUser(recipient).getFirstName();
        Messaging messaging = new Messaging(String.format(ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("helloMessage"), username),recipient);
        sendMessaging(messaging);
    }

    @Override
    public void sendErrorMessage(Long recipient) {
        Messaging messaging = new Messaging(ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("errorMessage"), recipient);
        sendMessaging(messaging);

    }

    @Override
    public void sendMessaging(Messaging messaging){
        ResponseEntity<?> response = new RestTemplate().postForEntity(FACEBOOK_MESSAGES_URL+PAGE_ACCESS_TOKEN, messaging, Messaging.class);
    }
}