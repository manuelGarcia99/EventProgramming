package com.example.proj;

import javafx.scene.Node;

public class ClickableNode {
    public final Node node;
    private boolean clicked;

    public ClickableNode(javafx.scene.Node node) {
        this.node = node;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
