package com.gestion.tienda.repositories;

import com.gestion.tienda.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findAllByCantidadGreaterThanOrderByIdDesc(int cantidad);

    List<ProductModel> findTop15ByCantidadGreaterThanOrderByIdDesc(int cantidad);


    List<ProductModel> findAllByNombreContainsIgnoreCaseAndCantidadGreaterThan(String nombre, int cantidad);

    List<ProductModel> findAllByMarcaContainsIgnoreCaseAndCantidadGreaterThan(String marca, int cantidad);

    List<ProductModel> findAllByColorContainingIgnoreCaseAndCantidadGreaterThan(String color, int cantidad);

    List<ProductModel> findAllByNombreContainsIgnoreCaseAndMarcaContainsIgnoreCaseAndCantidadGreaterThan(String nombre, String marca, int cantidad);

    List<ProductModel> findAllByNombreContainsIgnoreCaseAndColorContainsIgnoreCaseAndCantidadGreaterThan(String nombre, String color, int cantidad);

    List<ProductModel> findAllByMarcaContainsIgnoreCaseAndColorContainsIgnoreCaseAndCantidadGreaterThan(String marca, String color, int cantidad);


    List<ProductModel> findAllByColorContainingIgnoreCaseAndMarcaContainingIgnoreCaseAndNombreContainsIgnoreCaseAndCantidadGreaterThan(String color, String marca, String nombre, int cantidad);
}
