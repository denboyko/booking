package com.botscrew.models.messanger;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

public class Event {

    private String object;

    private List<Entry> entry;

    public Event() {
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}