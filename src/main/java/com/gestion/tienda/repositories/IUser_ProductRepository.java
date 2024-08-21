package com.gestion.tienda.repositories;

import com.gestion.tienda.models.User_ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser_ProductRepository extends JpaRepository<User_ProductModel, Long> {

}
