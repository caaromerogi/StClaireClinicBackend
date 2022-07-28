package com.sofka.stclaireclinic.service.interfaces;

import com.sofka.stclaireclinic.entity.MedicalSpecialty;

import java.util.List;

public interface MedicalSpecialtyService {
    List<MedicalSpecialty> getAllMedicalSpecialties();

    MedicalSpecialty getMedicalSpecialtyById(Long id);

    MedicalSpecialty createMedicalSpecialty(MedicalSpecialty medicalSpecialty);

    MedicalSpecialty updateMedicalSpecialty(Long id, MedicalSpecialty medicalSpecialty);

    void deleteMedicalSpecialty(Long id);

}
