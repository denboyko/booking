package com.botscrew.models.apiai;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class Metadata {

    private String intentId;

    private Boolean webhookUsed;

    private Boolean webhookForSlotFillingUsed;

    private String intentName;

    public Metadata() {
    }

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public Boolean getWebhookUsed() {
        return webhookUsed;
    }

    public void setWebhookUsed(Boolean webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    public Boolean getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    public void setWebhookForSlotFillingUsed(Boolean webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }
}
