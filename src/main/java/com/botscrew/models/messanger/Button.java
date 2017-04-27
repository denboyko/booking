package com.botscrew.models.messanger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Den Boyko
 * @version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Button {

    private String type;

    private String url;

    private String title;

    @JsonProperty("webview_height_ratio")
    private String webviewHeightRatio;

    private String payload;

    public Button() {
    }

    public Button(String type, String url, String title, String webviewHeightRatio) {
        this.type = type;
        this.url = url;
        this.title = title;
        this.webviewHeightRatio = webviewHeightRatio;
    }

    public Button(String type, String title, String payload) {
        this.type = type;
        this.title = title;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebviewHeightRatio() {
        return webviewHeightRatio;
    }

    public void setWebviewHeightRatio(String webviewHeightRatio) {
        this.webviewHeightRatio = webviewHeightRatio;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
