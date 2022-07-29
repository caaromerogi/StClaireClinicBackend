package com.sofka.stclaireclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalSpecialtyDTO {
    private Long id;


    @Size(min = 5, max = 100, message = "The number of characters are not in the acceptable range (5 to 100 char)")
    private String name;

    @Size(min = 10, max = 45, message = "The number of characters are not in the acceptable range (10 o 45 char)")
    private String physicianInCharge;

    private List<PatientDTO> patients = new ArrayList<>();

    public void addPatientDTO(PatientDTO patientDTO){
        patients.add(patientDTO);
    }
}
