package com.botscrew.models.messanger;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Payload {

    private String template_type;
    private String text;
    private List<Button> buttons;
    private List<Element> elements;

    public Payload() {
    }

    public Payload(String template_type, String text, List<Button> buttons) {
        this.template_type = template_type;
        this.text = text;
        this.buttons = buttons;
    }

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
