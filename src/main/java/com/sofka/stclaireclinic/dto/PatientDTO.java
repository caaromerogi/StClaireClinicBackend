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
    private String date;
    private List<DateDTO> dates = new ArrayList<>();

    private int numberOfAppointments;



}
