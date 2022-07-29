package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.dto.PatientDTO;

public interface PatientService {

    PatientDTO getPatientById(Long id);

    PatientDTO updatePatient(Long id, PatientDTO patientDTO);

    void deletePatient(Long id);


}
