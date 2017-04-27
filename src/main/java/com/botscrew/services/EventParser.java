package com.botscrew.services;

import com.botscrew.models.messanger.Event;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface EventParser {

    void parseEvent(Event event);
}
