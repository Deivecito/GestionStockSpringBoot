package com.gestion.tienda.repositories;

import com.gestion.tienda.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findAllById(Long id);
}
