package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient updatePatientAppointments();

    void deletePatient(Long id);

    void deleteAllPatients();

}
