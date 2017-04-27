package com.botscrew.ApiAiController;

import com.botscrew.models.messanger.Event;
import com.botscrew.services.EventParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Den Boyko
 * @version 1.0
 */
@RestController
public class FacebookWebhookController {

    @Autowired
    private EventParser eventParser;

    @Value("${page.access.token}")
    private String PAGE_ACCESS_TOKEN;
    @RequestMapping(value = "/subscription", method = RequestMethod.GET)
    public ResponseEntity<String> verifyWebhook(@RequestParam(name = "hub.verify_token") String token,
                                                @RequestParam(name = "hub.challenge") String challenge) {
        if (token.equals(PAGE_ACCESS_TOKEN)) {
            return new ResponseEntity<>(challenge, new HttpHeaders(),HttpStatus.OK);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public ResponseEntity<Void> message(@RequestBody Event event) {
        if (event != null) {
            if (event.getObject().equals("page")) {
                eventParser.parseEvent(event);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}