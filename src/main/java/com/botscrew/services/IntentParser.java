package com.botscrew.services;

import com.botscrew.models.apiai.Result;
import com.botscrew.models.entities.User;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface IntentParser {
    void parseIntent(Result result, User user);
    void parseIntent(ai.api.model.Result result, User user);
}
