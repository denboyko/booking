package com.botscrew.models.messanger;

/**
 * @author Den Boyko
 * @version 1.0
 */

public class Recipient {

    private Long id;

    public Recipient() {
    }

    public Recipient(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
