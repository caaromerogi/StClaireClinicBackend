package com.sofka.stclaireclinic.mapper;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.entity.MedicalSpecialty;

import java.util.ArrayList;
import java.util.List;

public class MedicalSpecialtyMapper {

    PatientMapper patientMapper = new PatientMapper();

    public MedicalSpecialtyDTO convertToDTO(MedicalSpecialty medicalSpecialty){
        MedicalSpecialtyDTO medicalSpecialtyDTO = new MedicalSpecialtyDTO();
        medicalSpecialtyDTO.setId(medicalSpecialty.getId());
        medicalSpecialtyDTO.setName(medicalSpecialty.getName());
        medicalSpecialtyDTO.setPhysicianInCharge(medicalSpecialty.getPhysicianInCharge());
        medicalSpecialtyDTO.setPatients(patientMapper.convertToPatientDTOList(medicalSpecialty.getPatients()));

        return medicalSpecialtyDTO;
    }

    public MedicalSpecialty convertToEntity(MedicalSpecialtyDTO medicalSpecialtyDTO){
        MedicalSpecialty medicalSpecialty = new MedicalSpecialty();
        medicalSpecialty.setId(medicalSpecialtyDTO.getId());
        medicalSpecialty.setName(medicalSpecialtyDTO.getName());
        medicalSpecialty.setPhysicianInCharge(medicalSpecialtyDTO.getPhysicianInCharge());
        medicalSpecialty.setPatients(patientMapper.convertToPatientEntityList(medicalSpecialtyDTO.getPatients()));

        return medicalSpecialty;
    }

    public List<MedicalSpecialty> convertToMedicalSpecialtyEntity(List<MedicalSpecialtyDTO> medicalSpecialtyDTOList){
        List<MedicalSpecialty> medicalSpecialties = new ArrayList<>();
        medicalSpecialtyDTOList.forEach(medicalSpecialtyDTO -> medicalSpecialties.add(convertToEntity(medicalSpecialtyDTO)));
        return medicalSpecialties;
    }

    public List<MedicalSpecialtyDTO> convertToMedicalSpecialtyDTO(List<MedicalSpecialty> medicalSpecialties){
        List<MedicalSpecialtyDTO> medicalSpecialtiesDTO = new ArrayList<>();
        medicalSpecialties.forEach(medicalSpecialty -> medicalSpecialtiesDTO.add(convertToDTO(medicalSpecialty)));
        return medicalSpecialtiesDTO;
    }

}

