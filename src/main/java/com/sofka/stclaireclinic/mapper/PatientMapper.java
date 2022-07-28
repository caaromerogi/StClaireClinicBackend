package com.sofka.stclaireclinic.mapper;

import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {
    DateMapper dateMapper = new DateMapper();

    public PatientDTO convertToDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setDni(patient.getDni());
        patientDTO.setAge(patient.getAge());
        patientDTO.setNumberOfAppointments(patient.getNumberOfAppointments());
        patientDTO.setDates(dateMapper.convertToDateDTOList(patient.getDates()));

        return patientDTO;
    }

    public Patient convertToEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setDni(patientDTO.getDni());
        patient.setAge(patientDTO.getAge());
        patient.setNumberOfAppointments(patientDTO.getNumberOfAppointments());
        patient.setDates(dateMapper.convertToDateEntityList(patientDTO.getDates()));

        return patient;
    }

    public List<PatientDTO> convertToPatientDTOList(List<Patient> patients){
        List<PatientDTO> patientsDTO = new ArrayList<>();
        patients.forEach(patient -> patientsDTO.add(convertToDTO(patient)));

        return patientsDTO;
    }

    public List<Patient> convertToPatientEntityList(List<PatientDTO> patientsDTO){
        List<Patient> patients = new ArrayList<>();
        patientsDTO.forEach(patientDTO -> patients.add(convertToEntity(patientDTO)));

        return patients;
    }
}
