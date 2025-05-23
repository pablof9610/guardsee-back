package com.personal.project.guardsee.model;

import lombok.Data;

@Data
public class State {
    private String name;
    private Long quantity;

    public State() {}

    public State(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
