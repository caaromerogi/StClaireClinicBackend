package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;

import java.util.List;

public interface MedicalSpecialtyService {
    List<MedicalSpecialtyDTO> getAllMedicalSpecialties();

    MedicalSpecialtyDTO getMedicalSpecialtyById(Long id);

    MedicalSpecialtyDTO createMedicalSpecialty(MedicalSpecialtyDTO medicalSpecialtyDTO);

    MedicalSpecialtyDTO updateMedicalSpecialty(Long id, PatientDTO patientDTO);

    void deleteMedicalSpecialty(Long id);

}
