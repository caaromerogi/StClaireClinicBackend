package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.MedicalSpecialty;
import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.mapper.MedicalSpecialtyMapper;
import com.sofka.stclaireclinic.mapper.PatientMapper;
import com.sofka.stclaireclinic.respository.MedicalSpecialtyRepository;
import com.sofka.stclaireclinic.respository.PatientRepository;
import com.sofka.stclaireclinic.service.interfaces.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalSpecialtyServiceImpl implements MedicalSpecialtyService {

    @Autowired
    private MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Autowired
    private PatientRepository patientRepository;
    MedicalSpecialtyMapper medicalSpecialtyMapper = new MedicalSpecialtyMapper();
    PatientMapper patientMapper = new PatientMapper();

    @Override
    public List<MedicalSpecialtyDTO> getAllMedicalSpecialties() {
        List<MedicalSpecialty> medicalSpecialties;
        medicalSpecialties = medicalSpecialtyRepository.findAll();

        return medicalSpecialtyMapper.convertToMedicalSpecialtyDTO(medicalSpecialties);
    }

    @Override
    public MedicalSpecialtyDTO getMedicalSpecialtyById(Long id) {
        Optional<MedicalSpecialty> oMedicalSpecialty = medicalSpecialtyRepository.findById(id);
        if (oMedicalSpecialty.isPresent()) {
            MedicalSpecialty medicalSpecialty = oMedicalSpecialty.get();

            return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
        }

        return null;
    }

    @Override
    public MedicalSpecialtyDTO createMedicalSpecialty(MedicalSpecialtyDTO medicalSpecialtyDTO) {
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(medicalSpecialtyDTO);
        medicalSpecialty = medicalSpecialtyRepository.save(medicalSpecialty);

        return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
    }

    @Override
    public MedicalSpecialtyDTO updateMedicalSpecialty(Long idMedicalSpecialty, PatientDTO patientDTO) {
        MedicalSpecialtyDTO medicalSpecialtyDTO = getMedicalSpecialtyById(idMedicalSpecialty);
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(medicalSpecialtyDTO);
        Patient patient = patientMapper.convertToEntity(patientDTO);

        for (Patient p: medicalSpecialty.getPatients()) {
            if(p.getDni().equalsIgnoreCase(patientDTO.getDni())){
                patient.setId(p.getId());
                patient.setNumberOfAppointments(p.getNumberOfAppointments());
                patient.incrementNumberOfAppointment();
                patient.setMedicalSpecialty(medicalSpecialty);
                patientRepository.save(patient);


                medicalSpecialty.getPatients().remove(p);
                medicalSpecialty.addPatient(patient);
                medicalSpecialtyRepository.save(medicalSpecialty);

                return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
            }
        }

        patient.setMedicalSpecialty(medicalSpecialty);
        medicalSpecialty.addPatient(patient);
        medicalSpecialtyRepository.save(medicalSpecialty);
        patientRepository.save(patient);
        return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
    }



    @Override
    public void deleteMedicalSpecialty(Long id) {

    }
}
