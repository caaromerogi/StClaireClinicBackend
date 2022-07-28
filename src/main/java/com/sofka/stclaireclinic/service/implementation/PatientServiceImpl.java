package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.respository.PatientRepository;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        ArrayList<Patient> = patientRepository.findAll();
        return null;
    }

    @Override
    public Patient updatePatientAppointments() {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public void deleteAllPatients() {

    }
}
