package com.sofka.stclaireclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateDTO {
    private Long id;
    private String date;

    public DateDTO(String date) {
        this.date = date;
    }
}
