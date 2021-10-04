//package com.nathan.conference.service;
//
//import com.nathan.conference.repository.RegistrationRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RegistrationServiceImplementer implements RegistrationService{
//
//    private RegistrationRepo registrationRepo;
//
//    @Autowired
//    public RegistrationServiceImplementer(RegistrationRepo registrationRepo) {
//        this.registrationRepo = registrationRepo;
//    }
//
//    @Override
//    public void registerGuest(String name, String email){
//        registrationRepo.create(name, email);
//    }
//}
