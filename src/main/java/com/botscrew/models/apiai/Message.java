package com.botscrew.models.apiai;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class Message {

    private Integer type;

    private String speech;

    public Message() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
}
