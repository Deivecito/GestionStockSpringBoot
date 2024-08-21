package com.gestion.tienda.services;

import com.gestion.tienda.models.ProductModel;
import com.gestion.tienda.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public ArrayList<ProductModel> getProducts(){
        return new ArrayList<>(productRepository.findAllByCantidadGreaterThanOrderByIdDesc(0));
    }

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getProductById(Long id){
        return productRepository.findById(id);
    }

    public ProductModel updateProduct(ProductModel request, Long id){
        ProductModel product = productRepository.findById(id).get();
        product.setCantidad(request.getCantidad());
        product.setNombre(request.getNombre());
        product.setColor(request.getColor());
        product.setPrecio(request.getPrecio());
        product.setTalleXS(request.getTalleXS());
        product.setTalleS(request.getTalleS());
        product.setTalleM(request.getTalleM());
        product.setTalleL(request.getTalleL());
        product.setTalleXL(request.getTalleXL());
        product.setTalleXXL(request.getTalleXXL());
        product.setMarca(request.getMarca());
        productRepository.save(product);
    return product;
    }

    public boolean deleteProduct(Long id){
       try{
        productRepository.deleteById(id);
        return true;
       }catch (Exception error) {
            return false;
        }
    }

    public ArrayList<ProductModel> getTop15Products(){
        return new ArrayList<>(productRepository.findTop15ByCantidadGreaterThanOrderByIdDesc(0));
    }

    public List<ProductModel> getByNombreMarcaColor(String nombre, String marca, String color) {
        return productRepository.findAllByColorContainingIgnoreCaseAndMarcaContainingIgnoreCaseAndNombreContainsIgnoreCaseAndCantidadGreaterThan(nombre, marca, color, 0);
    }

    public List<ProductModel> getByNombreMarca(String nombre, String marca) {
        return productRepository.findAllByNombreContainsIgnoreCaseAndMarcaContainsIgnoreCaseAndCantidadGreaterThan(nombre, marca, 0);
    }

    public List<ProductModel> getByNombreColor(String nombre, String color) {
        return productRepository.findAllByNombreContainsIgnoreCaseAndColorContainsIgnoreCaseAndCantidadGreaterThan(nombre, color, 0);
    }

    public List<ProductModel> getByMarcaColor(String marca, String color) {
        return productRepository.findAllByMarcaContainsIgnoreCaseAndColorContainsIgnoreCaseAndCantidadGreaterThan(marca, color, 0);
    }

    public List<ProductModel> getByNombre(String nombre) {
        return productRepository.findAllByNombreContainsIgnoreCaseAndCantidadGreaterThan(nombre, 0);
    }

    public List<ProductModel> getByMarca(String marca) {
        return productRepository.findAllByMarcaContainsIgnoreCaseAndCantidadGreaterThan(marca, 0);
    }

    public List<ProductModel> getByColor(String color) {
        return productRepository.findAllByColorContainingIgnoreCaseAndCantidadGreaterThan(color, 0);
    }

}
