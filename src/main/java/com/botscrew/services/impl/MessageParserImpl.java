package com.botscrew.services.impl;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIContext;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.botscrew.models.apiai.Result;
import com.botscrew.models.entities.User;
import com.botscrew.models.messanger.Messaging;
import com.botscrew.services.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

@Service
public class MessageParserImpl implements MessageParser {

    private static Logger logger = LoggerFactory.getLogger(MessageParserImpl.class);

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private UserService userService;

    @Autowired
    private IntentParser intentParser;


    @Autowired
    private QuickReplyParserService quickReplyParserService;

    @Value("${api.ai.client.access.token}")
    private String API_AI_CLIENT_ACCESS_TOKEN;

    @Override
    public void parseMessage(Messaging messaging, Long sessionId) {

        if (messaging.getMessage().getQuickReply() != null) {
            quickReplyParserService.parseQuickReply(messaging);
            return;
        }
        String text = messaging.getMessage().getText();
        User user = userService.getUser(messaging.getSender().getId());
        if (text != null) {
            AIConfiguration configuration = new AIConfiguration(API_AI_CLIENT_ACCESS_TOKEN);

            AIDataService dataService = new AIDataService(configuration);
            try {
                AIRequest request = new AIRequest(text);
                Gson gson = new Gson();

                if (user.getStatus() != null) {
                    List<AIContext> aiContexts = Arrays.asList(gson.fromJson(user.getStatus(), AIContext[].class));
                    for (AIContext aiContext : aiContexts) {
                        request.addContext(aiContext);
                    }
                }

                AIResponse response = dataService.request(request);

                if(response.getResult().getContexts()!=null) {
                    user.setStatus(gson.toJson(response.getResult().getContexts()));
                } else {
                    intentParser.parseIntent(response.getResult(),user);
                }



                userService.updateUser(user);

                messageSenderService.sendMessaging(new Messaging(response.getResult().getFulfillment().getSpeech(), user.getId()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else
            messageSenderService.sendErrorMessage(messaging.getSender().getId());
    }
}