package com.sitis.prueba.backendSitis.repository;

import com.sitis.prueba.backendSitis.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
