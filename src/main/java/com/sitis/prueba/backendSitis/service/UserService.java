package com.sitis.prueba.backendSitis.service;

import com.sitis.prueba.backendSitis.model.User;
import com.sitis.prueba.backendSitis.model.UserLogin;

import java.util.List;

public interface UserService {
    //Autorizar
    Boolean userAutorizado(UserLogin userLogin);

    Iterable<User> getUsers();

    User newUser(User newUser);

    Boolean verifiedUsername(String username);


}
