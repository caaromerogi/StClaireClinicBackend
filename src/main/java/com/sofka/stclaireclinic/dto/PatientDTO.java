package com.sofka.stclaireclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    @Size(min = 10, max = 45, message = "The number of characters are not in the acceptable range (10 to 45 char)")
    private String name;

    private Long dni;

    @Min(value = 1, message = "From must be greater than zero")
    private String age;

    private String date;

    private Long numberOfAppointments;

    private List<DateDTO> dates = new ArrayList<>();

}
