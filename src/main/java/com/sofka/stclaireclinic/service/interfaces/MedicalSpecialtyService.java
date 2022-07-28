package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;

import java.util.List;

public interface MedicalSpecialtyService {
    List<MedicalSpecialtyDTO> getAllMedicalSpecialties();

    MedicalSpecialtyDTO getMedicalSpecialtyById(Long id);

    MedicalSpecialtyDTO createMedicalSpecialty(MedicalSpecialtyDTO medicalSpecialtyDTO);

    MedicalSpecialtyDTO updateOrCreatePatient(Long id, PatientDTO patientDTO);

    MedicalSpecialtyDTO updateMedicalSpecialty(Long id, MedicalSpecialtyDTO medicalSpecialtyDTO);

    void deleteAllPatients(Long id);

    void deleteMedicalSpecialty(Long id);

}
