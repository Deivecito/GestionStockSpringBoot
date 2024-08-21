package com.gestion.tienda.controllers;

import com.gestion.tienda.models.ProductModel;
import com.gestion.tienda.models.UserModel;
import com.gestion.tienda.services.ProductService;
import com.gestion.tienda.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping(path = "/{id}")
        public ArrayList<UserModel> getUserById(@PathVariable("id") long id){
            return this.userService.getUserById(id);
        }
}
