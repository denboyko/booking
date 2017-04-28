package com.botscrew.services.impl;

import com.botscrew.models.apiai.Webhook;
import com.botscrew.models.entities.User;
import com.botscrew.models.enums.apiai.Source;
import com.botscrew.services.ApiAiWebhookParser;
import com.botscrew.services.IntentParser;
import com.botscrew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author Den Boyko
 * @version 1.0
 */
@Service
public class ApiAiWebhookParserImpl implements ApiAiWebhookParser {

    @Autowired
    private UserService userService;

    @Autowired
    private IntentParser intentParser;

    @Override
    public void parseApiAiWebhook(Webhook webhook) {
        User user = null;
        if(webhook.getOriginalRequest()!=null) {

            switch (Source.valueOf(webhook.getOriginalRequest().getSource())) {
                case facebook: {
                    user = userService.getUser(webhook.getOriginalRequest().getData().getSender().getId());
                    break;
                }
            }

            intentParser.parseIntent(webhook.getResult(), user);
        }
    }
}
