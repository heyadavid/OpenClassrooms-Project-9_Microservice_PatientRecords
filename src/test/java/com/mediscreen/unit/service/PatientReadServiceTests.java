package com.mediscreen.unit.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientReadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientReadServiceTests {

    @Autowired
    PatientReadService patientReadService;
    @Autowired
    PatientRepository patientRepository;

    @Test
    public void shouldGetPatientById() {

        Patient patient = patientRepository.save(new Patient("Ron", "WEASLEY", "M", LocalDate.now().minusYears(12),
                "The Borrow, Ottery St. Catchpole", "791-145-6752"));
        Long patientId = patient.getPatientId();
        Patient actualPatient = patientReadService.readPatientById(patientId);

        assertEquals(patient, actualPatient);
    }

    @Test
    public void shouldGetPatientList() {

        Collection<Patient> patientList = new ArrayList<>();
        Patient firstPatient = new Patient("Harry", "POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456");
        patientList.add(firstPatient);
        Patient secondPatient = new Patient("Ron", "WEASLEY", "M", LocalDate.now().minusYears(12),
                "The Borrow, Ottery St. Catchpole", "791-145-6752");
        patientList.add(secondPatient);
        Patient thirdPatient = new Patient("Hermione", "GRANGER", "F", LocalDate.now().minusYears(12),
                "8 Heathgate, Hampstead Garden Suburb, London", "791-963-4175");
        patientList.add(thirdPatient);
        Collection<Patient> actualPatientList = patientReadService.readPatientList();

        assertEquals(patientList, actualPatientList);
    }
}
