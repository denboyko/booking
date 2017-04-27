package com.botscrew.ApiAiController;


import com.botscrew.models.apiai.Webhook;
import com.botscrew.services.ApiAiWebhookParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Den Boyko
 * @version 1.0
 */

@RestController
public class ApiAiWebhookController {

    @Autowired
    private ApiAiWebhookParser apiAiWebhookParser;

    @RequestMapping(value = "/apiai",method = RequestMethod.POST)
    public ResponseEntity<Void> message(@RequestBody Webhook webhook) {
        apiAiWebhookParser.parseApiAiWebhook(webhook);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
