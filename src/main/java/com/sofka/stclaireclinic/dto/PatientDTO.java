package com.sofka.stclaireclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String dni;
    private String age;
    private List<DateDTO> dates = new ArrayList<>();

    private int numberOfAppointments;

    public PatientDTO(String name, String dni, String age, List<DateDTO> dates) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.dates = dates;
    }

}
