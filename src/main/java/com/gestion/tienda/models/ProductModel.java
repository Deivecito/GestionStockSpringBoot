package com.gestion.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String marca;

    @Column
    private String color;

    @Column
    private int precio;

    @Column
    private int talleXS;

    @Column
    private int talleS;

    @Column
    private int talleM;

    @Column
    private int talleL;

    @Column
    private int talleXL;

    @Column
    private int talleXXL;

    @Column
    private int cantidad;
}

