package com.sofka.stclaireclinic.controller;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private MedicalSpecialtyService medicalSpecialtyService;

    @GetMapping()
    public List<MedicalSpecialtyDTO> getAllMedicalSpecialty(){
        return medicalSpecialtyService.getAllMedicalSpecialties();
    }

    @GetMapping("/{id}")
    public MedicalSpecialtyDTO getMedicalSpecialtyById(@PathVariable Long id){
        return medicalSpecialtyService.getMedicalSpecialtyById(id);
    }

    @PostMapping("/create/medical-specialty")
    public MedicalSpecialtyDTO createMedicalSpecialty(@RequestBody MedicalSpecialtyDTO medicalSpecialtyDTO){
        return medicalSpecialtyService.createMedicalSpecialty(medicalSpecialtyDTO);
    }

    @PostMapping("/create/{id}/patient")
    public MedicalSpecialtyDTO updateMedicalSpecialty(@PathVariable("id") Long id, @RequestBody PatientDTO patientDTO) {
        return medicalSpecialtyService.updateMedicalSpecialty(id, patientDTO);
    }
}
