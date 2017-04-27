package com.botscrew.models.messanger;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Den Boyko
 * @version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Messaging {

    private Sender sender;

    private Recipient recipient;

    private Long timestamp;

    private Message message;

    private Postback postback;

    public Messaging() {
    }

    public Messaging(String text, Long recipientId){
        this.message = new Message(text);
        this.recipient = new Recipient(recipientId);
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Postback getPostback() {
        return postback;
    }

    public void setPostback(Postback postback) {
        this.postback = postback;
    }
}
