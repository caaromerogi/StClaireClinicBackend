package com.sofka.stclaireclinic.controller;

import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PutMapping("/update/patient/{id}")
    public PatientDTO updatePatient (@PathVariable("id") Long id,
                                     @Valid @RequestBody PatientDTO patientDTO,
                                     BindingResult result){

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return null;
        }
        return patientService.updatePatient(id, patientDTO);
    }

    @DeleteMapping("/delete/patient/{id-patient}")
    public void deletePatient(@PathVariable("id-patient") Long id) {
        patientService.deletePatient(id);
    }
}
