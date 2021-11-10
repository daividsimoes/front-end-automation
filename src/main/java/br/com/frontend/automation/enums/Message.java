package br.com.frontend.automation.enums;

import lombok.Getter;

@Getter
public enum Message {

    CART_SUB_ITEM("Subtotal (1 item):"),
    CART_SUB_ITEMS("Subtotal ({0} items):");

    private String message;

    Message(String message) {

        this.message = message;
    }
}
