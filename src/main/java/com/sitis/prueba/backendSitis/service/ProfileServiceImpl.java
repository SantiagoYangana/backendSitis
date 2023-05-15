package com.sitis.prueba.backendSitis.service;

import com.sitis.prueba.backendSitis.model.Profile;
import com.sitis.prueba.backendSitis.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Iterable<Profile> getProfiles() {
        return this.profileRepository.findAll();
    }

    @Override
    public Profile newProfile(Profile newProfile) {
        return this.profileRepository.save(newProfile);
    }
}
