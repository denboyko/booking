package com.botscrew.models.apiai;

import com.botscrew.models.messanger.Messaging;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class OriginalRequest {

    private String source;

    private Messaging data;

    public OriginalRequest() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Messaging getData() {
        return data;
    }

    public void setData(Messaging data) {
        this.data = data;
    }
}
