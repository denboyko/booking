package com.botscrew.models.apiai;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class Fulfillment {

    private String speech;

    private List<Message> messages;

    public Fulfillment() {
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
