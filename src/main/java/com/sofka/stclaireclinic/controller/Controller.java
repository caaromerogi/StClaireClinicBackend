package com.sofka.stclaireclinic.controller;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PatientService patientService;

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
    public MedicalSpecialtyDTO updateOrCreatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patientDTO) {
        return medicalSpecialtyService.updateOrCreatePatient(id, patientDTO);
    }

    @PutMapping("/update/{id}")
    public MedicalSpecialtyDTO updateMedicalSpecialty(@PathVariable("id") Long id, @RequestBody MedicalSpecialtyDTO medicalSpecialtyDTO){
        return medicalSpecialtyService.updateMedicalSpecialty(id, medicalSpecialtyDTO);
    }

    @DeleteMapping("/delete/{id-medical-specialty}/patient/{id-patient}")
    public void deletePatient(@PathVariable("id-patient") Long id) {
        patientService.deletePatient(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalSpecialty(@PathVariable Long id){
        medicalSpecialtyService.deleteMedicalSpecialty(id);
    }

    @DeleteMapping("/delete/{id-medical-specialty}/patient/all")
    public void deleteAllPatientsdeleteAl(@PathVariable("id-medical-specialty") Long id){
        medicalSpecialtyService.deleteAllPatients(id);
    }
}
