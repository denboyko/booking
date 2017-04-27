package com.botscrew.models.messanger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Message {

    private String mid;

    private Integer seq;

    private String text;

    private Attachment attachment;

    @JsonProperty("quick_reply")
    private QuickReply quickReply;

    private List<QuickReply> quick_replies;

    public Message() {
    }

    public Message(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public List<QuickReply> getQuick_replies() {
        return quick_replies;
    }

    public QuickReply getQuickReply() {
        return quickReply;
    }

    public void setQuickReply(QuickReply quickReply) {
        this.quickReply = quickReply;
    }

    public void setQuick_replies(List<QuickReply> quick_replies) {
        this.quick_replies = quick_replies;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
