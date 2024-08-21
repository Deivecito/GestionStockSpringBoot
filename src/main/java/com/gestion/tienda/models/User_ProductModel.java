package com.gestion.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "bill_products")
public class User_ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    private List<ProductModel> products;

    private Long total;

    private LocalDateTime fecha;

}
