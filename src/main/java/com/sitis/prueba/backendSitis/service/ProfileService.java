package com.sitis.prueba.backendSitis.service;

import com.sitis.prueba.backendSitis.model.Profile;

public interface ProfileService {
    Iterable<Profile> getProfiles();
    Profile newProfile(Profile newProfile);
}
