package com.nathan.conference.repository;

import com.nathan.conference.model.Registration;
import java.util.List;
import java.util.Optional;

public interface RegistrationRepo  {

    int count();

    int save(Registration registration);

    int update(Registration registration);

    int deleteById(int id);

    List<Registration> findAll();

    List<Registration> findByNameAndEmail(String name, String email);

   // Optional<Registration> findById(Long id);

    String getNameById(int id);



}
