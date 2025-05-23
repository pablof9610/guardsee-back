package com.personal.project.guardsee.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductStateDTO {
    private String name;
    private List<State> states;

    public ProductStateDTO(String name) {
        this.name = name;
        states = new ArrayList<>(List.of());
    }

    public void addState(State state) {
        states.add(state);
    }
}
