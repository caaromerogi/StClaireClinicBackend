package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.dto.PatientDTO;


import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);

    void deletePatient(Long id);


}
