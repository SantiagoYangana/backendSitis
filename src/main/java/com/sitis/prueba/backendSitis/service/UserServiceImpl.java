package com.sitis.prueba.backendSitis.service;

import com.sitis.prueba.backendSitis.model.Profile;
import com.sitis.prueba.backendSitis.model.User;
import com.sitis.prueba.backendSitis.model.UserLogin;
import com.sitis.prueba.backendSitis.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    public void insertStaticData() {
//        // Crear el perfil "administrador"
//        Profile adminProfile = new Profile();
//        adminProfile.setName("administrador");
//        entityManager.persist(adminProfile);
//
//        // Crear el usuario "admin" con el perfil "administrador"
//        User adminUser = new User();
//        adminUser.setUsername("admin");
//        adminUser.setEmail("admin@example.com");
//        adminUser.setPassword("admin");
//        adminUser.setProfile(adminProfile);
//        entityManager.persist(adminUser);
//    }

    @Override
    public Boolean userAutorizado(UserLogin userLogin) {
        Boolean userRegister = this.userRepository.existsById(userLogin.getUsername());
        Boolean passwordRegister = this.userRepository.existsById(userLogin.getPassword());
        if (userRegister && passwordRegister){
            return true;
        }
        return false;
    }

    @Override
    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User newUser(User newUser) {
        return this.userRepository.save(newUser);
    }

    @Override
    public Boolean verifiedUsername(String username) {
        return this.userRepository.existsById(username);
    }
}
