package com.mediscreen.service;

import com.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCreationService {

    @Autowired
    private PatientRepository patientRepository;
}
