package com.sofka.stclaireclinic.mapper;

import com.sofka.stclaireclinic.dto.DateDTO;
import com.sofka.stclaireclinic.entity.Date;

import java.util.ArrayList;
import java.util.List;

public class DateMapper {

    public DateDTO convertToDTO(Date date){
        DateDTO dateDTO = new DateDTO();
        dateDTO.setId(date.getId());
        dateDTO.setDate(date.getDate());
        return dateDTO;
    }

    public Date convertToEntity(DateDTO dateDTO){
        Date date = new Date();
        date.setId(dateDTO.getId());
        date.setDate(dateDTO.getDate());
        return date;
    }

    public List<DateDTO> convertToDateDTOList(List<Date> dates){
        List<DateDTO> datesDTO = new ArrayList<DateDTO>();
        dates.forEach(date -> datesDTO.add(convertToDTO(date)));
        return datesDTO;
    }

    public  List<Date> convertToDateEntityList(List<DateDTO> datesDTO){
        List<Date> dates = new ArrayList<Date>();
        datesDTO.forEach(dateDTO -> dates.add(convertToEntity(dateDTO)));
        return dates;
    }
}
