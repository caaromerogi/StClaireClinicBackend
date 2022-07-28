package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.MedicalSpecialty;
import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.mapper.MedicalSpecialtyMapper;
import com.sofka.stclaireclinic.mapper.PatientMapper;
import com.sofka.stclaireclinic.respository.PatientRepository;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    PatientMapper patientMapper = new PatientMapper();

    @Autowired
    private PatientRepository patientRepository;



    @Override
    public List<PatientDTO> getAllPatients() {
        List<PatientDTO> patientsDTO = new ArrayList<>();
        patientsDTO = patientMapper.convertToPatientDTOList(patientRepository.findAll());

        return patientsDTO;
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Optional<Patient> oPatient = patientRepository.findById(id);
        if (oPatient.isPresent()){
            Patient patient = oPatient.get();
            return patientMapper.convertToDTO(patient);
        }
        return null;
    }


    @Override
    public void deletePatient(Long id) {
        PatientDTO patientDTO = getPatientById(id);
        Patient patient = patientMapper.convertToEntity(patientDTO);
        patientRepository.delete(patient);
    }


}
