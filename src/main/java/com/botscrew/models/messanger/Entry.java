package com.botscrew.models.messanger;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

public class Entry {

    private Long id;

    private Long time;

    private List<Messaging> messaging;

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<Messaging> getMessaging() {
        return messaging;
    }

    public void setMesseging(List<Messaging> messaging) {
        this.messaging = messaging;
    }


}
