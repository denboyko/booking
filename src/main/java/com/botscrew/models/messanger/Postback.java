package com.botscrew.models.messanger;

/**
 * @author Den Boyko
 * @version 1.0
 */

public class Postback {
    private String payload;

    public Postback() {
    }

    public Postback(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
