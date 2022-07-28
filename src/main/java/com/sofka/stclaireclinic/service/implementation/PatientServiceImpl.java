package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.MedicalSpecialty;
import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.mapper.PatientMapper;
import com.sofka.stclaireclinic.respository.PatientRepository;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalSpecialtyService medicalSpecialtyService;

    private PatientMapper patientMapper;

    @Override
    public List<PatientDTO> getAllPatients() {
        List<PatientDTO> patientsDTO = new ArrayList<>();
        patientsDTO = patientMapper.convertToPatientDTOList(patientRepository.findAll());

        return patientsDTO;
    }



    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public void deleteAllPatients() {

    }
}
