package com.botscrew.models;

import ai.api.model.AIResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class Response extends AIResponse {

    @JsonIgnore
    private String originalRequest;

    public Response() {
        super();
    }

    public String getOriginalRequest() {
        return originalRequest;
    }

    public void setOriginalRequest(String originalRequest) {
        this.originalRequest = originalRequest;
    }
}
