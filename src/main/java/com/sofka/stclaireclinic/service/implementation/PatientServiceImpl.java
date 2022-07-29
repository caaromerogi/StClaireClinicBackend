package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.dto.DateDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.Date;
import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.mapper.DateMapper;
import com.sofka.stclaireclinic.mapper.PatientMapper;
import com.sofka.stclaireclinic.respository.DateRepository;
import com.sofka.stclaireclinic.respository.PatientRepository;
import com.sofka.stclaireclinic.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    PatientMapper patientMapper = new PatientMapper();

    DateMapper dateMapper = new DateMapper();

    @Autowired
    private DateRepository dateRepository;

    @Autowired
    private PatientRepository patientRepository;

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
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id).orElse(null);
        DateDTO dateDTO = new DateDTO(patientDTO.getDate());
        Date date = dateMapper.convertToEntity(dateDTO);

        date.setPatient(patient);
        assert patient != null;
        patient.addDate(date);
        patient.incrementNumberOfAppointment();
        patientRepository.save(patient);

        return patientMapper.convertToDTO(patient);
    }

    @Override
    public void deletePatient(Long id) {
        PatientDTO patientDTO = getPatientById(id);
        Patient patient = patientMapper.convertToEntity(patientDTO);
        patientRepository.delete(patient);
    }


}
