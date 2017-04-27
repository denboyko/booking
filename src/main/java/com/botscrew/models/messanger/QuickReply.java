package com.botscrew.models.messanger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Den Boyko
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuickReply {

    @JsonProperty("content_type")
    private String contentType;

    private String title;

    private String payload;

    @JsonProperty("image_url")
    private String imageUrl;

    public QuickReply() {
    }

    public QuickReply(String contentType, String title, String payload) {
        this.contentType = contentType;
        this.title = title;
        this.payload = payload;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
