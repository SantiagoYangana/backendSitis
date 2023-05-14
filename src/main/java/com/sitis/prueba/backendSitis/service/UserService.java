package com.sitis.prueba.backendSitis.service;

import com.sitis.prueba.backendSitis.model.Response;
import com.sitis.prueba.backendSitis.model.User;
import com.sitis.prueba.backendSitis.model.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    //Autorizar
    Response userAutorizado(UserLogin userLogin);

    Iterable<User> getUsers();

    User newUser(User newUser);

    Boolean verifiedUsername(String username);

    Page<User> paginationUsers(Pageable pageable);


}
