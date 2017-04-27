package com.botscrew.models.messanger;


/**
 * @author Den Boyko
 * @version 1.0
 */

public class Attachment {

    private String type;
    private Payload payload;

    public Attachment() {
    }

    public Attachment(String type, Payload payload) {
        this.type = type;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
