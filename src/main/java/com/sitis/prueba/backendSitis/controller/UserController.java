package com.sitis.prueba.backendSitis.controller;

import com.sitis.prueba.backendSitis.model.Profile;
import com.sitis.prueba.backendSitis.model.Response;
import com.sitis.prueba.backendSitis.model.User;
import com.sitis.prueba.backendSitis.model.UserLogin;
import com.sitis.prueba.backendSitis.service.ProfileService;
import com.sitis.prueba.backendSitis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin (origins = {"http://localhost:4200","http://localhost:8080"})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    @PostMapping("/auth")
    public Response autorizarUser(@RequestBody UserLogin userLogin){
        return this.userService.userAutorizado(userLogin);
    }

    @GetMapping("/listUsers")
    public Iterable<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/listProfiles")
    public Iterable<Profile> getProfiles(){
        return this.profileService.getProfiles();
    }

    @PostMapping("/newUser")
    public User newUser(@RequestBody User newUser){
        return this.userService.newUser(newUser);
    }

    @PostMapping("/newProfile")
    public Profile newUser(@RequestBody Profile newProfile){
        return this.profileService.newProfile(newProfile);
    }

    @PostMapping("/verifiedUsername")
    public Boolean verifiedUsername(@RequestBody String username){
        return this.userService.verifiedUsername(username);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> paginationUser(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "5") int size
    ){
        Page<User> usersByPage=this.userService.paginationUsers(PageRequest.of(page,size));
        return new ResponseEntity<Page<User>>(usersByPage, HttpStatusCode.valueOf(200));
    }

}
