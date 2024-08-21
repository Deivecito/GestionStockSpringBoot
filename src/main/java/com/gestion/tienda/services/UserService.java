package com.gestion.tienda.services;

import com.gestion.tienda.models.ProductModel;
import com.gestion.tienda.models.UserModel;
import com.gestion.tienda.repositories.IProductRepository;
import com.gestion.tienda.repositories.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUserById(Long id){
        return new ArrayList<>(userRepository.findAllById(id));
    }
}
