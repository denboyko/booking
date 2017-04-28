package com.botscrew.services.impl;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIContext;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.botscrew.models.entities.User;
import com.botscrew.models.messanger.Messaging;
import com.botscrew.services.*;
import com.google.gson.Gson;
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

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private UserService userService;

    @Autowired
    private IntentParser intentParser;


    @Autowired
    private QuickReplyParser quickReplyParser;

    @Value("${api.ai.client.access.token}")
    private String API_AI_CLIENT_ACCESS_TOKEN;

    @Override
    public void parseMessage(Messaging messaging, Long sessionId)throws Exception {

        if (messaging.getMessage().getQuickReply() != null) {
            quickReplyParser.parseQuickReply(messaging);
            return;
        }
        String text = messaging.getMessage().getText();
        User user = userService.getUser(messaging.getSender().getId());
        if (text != null) {
            AIConfiguration configuration = new AIConfiguration(API_AI_CLIENT_ACCESS_TOKEN);

            AIDataService dataService = new AIDataService(configuration);
                AIRequest request = new AIRequest(text);
                Gson gson = new Gson();

                if (user.getContexts()!=null && !user.getContexts().equals("null")) {
                    List<AIContext> aiContexts = Arrays.asList(gson.fromJson(user.getContexts(), AIContext[].class));
                    for (AIContext aiContext : aiContexts) {
                        request.addContext(aiContext);
                    }
                }
                AIResponse response = dataService.request(request);
                user.setContexts(gson.toJson(response.getResult().getContexts()));
                messageSenderService.sendMessaging(new Messaging(response.getResult().getFulfillment().getSpeech(), user.getId()));

                if(user.getContexts().equals("[]")) {
                    intentParser.parseIntent(response.getResult(),user);
                }

                userService.updateUser(user);

        } else
            messageSenderService.sendErrorMessage(messaging.getSender().getId());
    }
}