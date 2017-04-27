package com.botscrew.services.impl;


import com.botscrew.models.entities.Room;
import com.botscrew.models.enums.messanger.AttachmentType;
import com.botscrew.models.enums.messanger.ButtonType;
import com.botscrew.models.enums.messanger.PayloadType;
import com.botscrew.models.enums.messanger.TemplateType;
import com.botscrew.models.messanger.*;
import com.botscrew.services.MessageSenderService;
import com.botscrew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
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
        Messaging messaging = new Messaging(String.format(ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("message.hello"), username),recipient);
        sendMessaging(messaging);
    }

    @Override
    public void sendErrorMessage(Long recipient) {
        Messaging messaging = new Messaging(ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("message.error"), recipient);
        sendMessaging(messaging);

    }

    @Override
    public void sendBookedRooms(Long recipient, Integer num){
        com.botscrew.models.entities.User user = userService.getUser(recipient);
        Messaging messaging = new Messaging();
        messaging.setRecipient(new Recipient(recipient));
        messaging.setMessage(new Message());
        messaging.getMessage().setAttachment(new Attachment());
        messaging.getMessage().getAttachment().setType(AttachmentType.template.name());
        Payload payload = new Payload();
        payload.setTemplate_type(TemplateType.generic.name());
        payload.setElements(new ArrayList<>());
        List<Room> rooms = user.getRooms();
        int size = rooms.size();
        for (Room room: rooms.subList(num*9,size)) {
            Element element = new Element();
            element.setButtons(new ArrayList<>());
            element.getButtons().add(new Button(ButtonType.postback.name(),ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("button.delete"), PayloadType.DELETE+"?"+room.getId()));
            element.setTitle(room.getLocation());
            element.setSubtitle("For " + room.getRoomSize()+ "people, \n" + room.getDate() + ",\n for " + room.getNights()+ " nights");
            payload.getElements().add(element);
        }
        if(payload.getElements().size()>10){
            payload.setElements(payload.getElements().subList(0,9));
            Element element = new Element();
            element.setTitle(ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("clickToSeeNextApps"));
            element.setButtons(new ArrayList<>());
            element.getButtons().add(new Button(ButtonType.postback.name(),ResourceBundle.getBundle("messages", new Locale(userService.getUser(recipient).getLocale())).getString("button.next"), PayloadType.NEXT_ROOMS.name() + "?"+(num+1)));
            payload.getElements().add(element);
        }
        messaging.getMessage().getAttachment().setPayload(payload);
        sendMessaging(messaging);
    }

    @Override
    public void sendMessaging(Messaging messaging){
        ResponseEntity<?> response = new RestTemplate().postForEntity(FACEBOOK_MESSAGES_URL+PAGE_ACCESS_TOKEN, messaging, Messaging.class);
    }
}