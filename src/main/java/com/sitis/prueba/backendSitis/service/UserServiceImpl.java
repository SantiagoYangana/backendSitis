package com.sitis.prueba.backendSitis.service;
import com.sitis.prueba.backendSitis.model.Response;
import com.sitis.prueba.backendSitis.model.User;
import com.sitis.prueba.backendSitis.model.UserLogin;
import com.sitis.prueba.backendSitis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
    public Response userAutorizado(UserLogin userLogin) {
        Response respuesta = new Response();
        String usernameLogin = userLogin.getUsername();
        String passwordLogin = userLogin.getPassword();
        Boolean userRegister = this.userRepository.existsById(usernameLogin);
        if (userRegister){
            Optional<User> userOptional;
            userOptional =this.userRepository.findById(usernameLogin);
            if(userOptional.get().getPassword().equalsIgnoreCase(passwordLogin)){
                respuesta.setResponse(userOptional.get().getProfile().getName()+","+userOptional.get().getUsername());
                respuesta.setStatus("OK");
                return respuesta;
            }
            respuesta.setResponse("");
            respuesta.setStatus("Error de contraseña");
            return respuesta;
        }
        respuesta.setStatus("Error de Autenticacion");
        respuesta.setResponse("");
        return respuesta;
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

    @Override
    public Page<User> paginationUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }
}
