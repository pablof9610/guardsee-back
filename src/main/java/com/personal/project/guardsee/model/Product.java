package com.personal.project.guardsee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serialNumber;
    private String vendor;
    private String model;
    private String ticket;
    private String detail;
    private String state;
}
