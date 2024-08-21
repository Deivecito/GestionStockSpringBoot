package com.gestion.tienda.controllers;

import com.gestion.tienda.models.ProductModel;
import com.gestion.tienda.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<ProductModel> getProducts(){
        return this.productService.getTop15Products();
    }

    @GetMapping(path = "/all")
    public ArrayList<ProductModel> getAllProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return this.productService.saveProduct(product);
    }

    @GetMapping(path = "/id/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id){
        return this.productService.getProductById(id);
    }

    @PutMapping(path = "/{id}")
    public ProductModel updateProduct(@RequestBody ProductModel product, @PathVariable("id") Long id){
        return this.productService.updateProduct(product, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct(@PathVariable Long id){
        boolean ok = this.productService.deleteProduct(id);
        if (ok){
            return "producto eliminado";
        }
        else {
            return "error al eliminar el producto";
        }
    }

    @GetMapping(path = "/filtros/{nombre}/{marca}/{color}")
    public List<ProductModel> getProductByFilters(
            @PathVariable("nombre") String nombre,
            @PathVariable("marca") String marca,
            @PathVariable("color") String color) {

        // Si nombre no es "0", invoca el método adecuado en el servicio
        if (!"0".equals(nombre) && !"0".equals(marca) && !"0".equals(color)) {
            return this.productService.getByNombreMarcaColor(nombre, marca, color);
        } else if (!"0".equals(nombre) && !"0".equals(marca)) {
            return this.productService.getByNombreMarca(nombre, marca);
        } else if (!"0".equals(nombre) && !"0".equals(color)) {
            return this.productService.getByNombreColor(nombre, color);
        } else if (!"0".equals(marca) && !"0".equals(color)) {
            return this.productService.getByMarcaColor(marca, color);
        } else if (!"0".equals(nombre)) {
            return this.productService.getByNombre(nombre);
        } else if (!"0".equals(marca)) {
            return this.productService.getByMarca(marca);
        } else if (!"0".equals(color)) {
            return this.productService.getByColor(color);
        } else {
            return this.productService.getTop15Products();
        }
    }
}
