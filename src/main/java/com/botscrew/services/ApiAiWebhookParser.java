package com.botscrew.services;

import com.botscrew.models.apiai.Webhook;

/**
 * @author Den Boyko
 * @version 1.0
 */
public interface ApiAiWebhookParser {
    void parseApiAiWebhook(Webhook webhook);
}
