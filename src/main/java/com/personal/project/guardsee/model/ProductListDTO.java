package com.personal.project.guardsee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListDTO {
    private String name;
    private Long quantity;
    private String detail;

    public ProductListDTO(String name, String state, Long quantity) {
        this.name = name;
        this.state = state;
        this.quantity = quantity;
    }
}
