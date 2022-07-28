package com.sofka.stclaireclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalSpecialtyDTO {
    private Long id;
    private String name;
    private String physicianInCharge;
    private List<PatientDTO> patients;

    public MedicalSpecialtyDTO(String name, String physicianInCharge, List<PatientDTO> patients) {
        this.name = name;
        this.physicianInCharge = physicianInCharge;
        this.patients = patients;
    }

    public void addPatientDTO(PatientDTO patientDTO){
        patients.add(patientDTO);
    }
}
