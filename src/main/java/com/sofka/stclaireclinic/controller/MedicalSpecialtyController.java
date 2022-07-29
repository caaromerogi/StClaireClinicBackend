package com.sofka.stclaireclinic.controller;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MedicalSpecialtyController {

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
    public MedicalSpecialtyDTO createMedicalSpecialty(@Valid @RequestBody MedicalSpecialtyDTO medicalSpecialtyDTO,
                                                      BindingResult result){
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return null;
        }
        return medicalSpecialtyService.createMedicalSpecialty(medicalSpecialtyDTO);
    }

    @PostMapping("/create/{id}/patient")
    public MedicalSpecialtyDTO CreatePatientInMedicalSpecialty(@PathVariable("id") Long id,
                                                               @Valid @RequestBody PatientDTO patientDTO,
                                                               BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return null;
        }

        return medicalSpecialtyService.createPatientInMedicalSpecialty(id, patientDTO);
    }

    @PutMapping("/update/{id}")
    public MedicalSpecialtyDTO updateMedicalSpecialty(@PathVariable("id") Long id,
                                                      @Valid @RequestBody MedicalSpecialtyDTO medicalSpecialtyDTO,
                                                      BindingResult result){
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return null;
        }
        return medicalSpecialtyService.updateMedicalSpecialty(id, medicalSpecialtyDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalSpecialty(@PathVariable Long id){
        medicalSpecialtyService.deleteMedicalSpecialty(id);
    }

    @DeleteMapping("/delete/{id-medical-specialty}/patient/all")
    public void deleteAllPatientsInSpecialty(@PathVariable("id-medical-specialty") Long id){
        medicalSpecialtyService.deleteAllPatientsInSpecialty(id);
    }
}
