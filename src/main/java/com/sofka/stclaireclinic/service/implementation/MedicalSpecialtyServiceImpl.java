package com.sofka.stclaireclinic.service.implementation;

import com.sofka.stclaireclinic.dto.DateDTO;
import com.sofka.stclaireclinic.dto.MedicalSpecialtyDTO;
import com.sofka.stclaireclinic.dto.PatientDTO;
import com.sofka.stclaireclinic.entity.Date;
import com.sofka.stclaireclinic.entity.MedicalSpecialty;
import com.sofka.stclaireclinic.entity.Patient;
import com.sofka.stclaireclinic.mapper.DateMapper;
import com.sofka.stclaireclinic.mapper.MedicalSpecialtyMapper;
import com.sofka.stclaireclinic.mapper.PatientMapper;
import com.sofka.stclaireclinic.respository.DateRepository;
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

    @Autowired
    private DateRepository dateRepository;

    MedicalSpecialtyMapper medicalSpecialtyMapper = new MedicalSpecialtyMapper();
    PatientMapper patientMapper = new PatientMapper();

    DateMapper dateMapper = new DateMapper();

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
    public MedicalSpecialtyDTO updateOrCreatePatient(Long idMedicalSpecialty, PatientDTO patientDTO) {
        MedicalSpecialtyDTO medicalSpecialtyDTO = getMedicalSpecialtyById(idMedicalSpecialty);
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(medicalSpecialtyDTO);
        Patient patient = patientMapper.convertToEntity(patientDTO);
        DateDTO dateDTO = new DateDTO(patientDTO.getDate());
        Date date = dateMapper.convertToEntity(dateDTO);

        for (Patient p: medicalSpecialty.getPatients()) {
            if(p.getDni().equalsIgnoreCase(patientDTO.getDni())){

                //Saving patient
                patient.setId(p.getId());
                patient.setNumberOfAppointments(p.getNumberOfAppointments());
                patient.incrementNumberOfAppointment();
                patient.setMedicalSpecialty(medicalSpecialty);
                date.setPatient(patient);
                patient.addDate(date);
                patientRepository.save(patient);



                //Saving the medical specialty
                medicalSpecialty.getPatients().remove(p);
                medicalSpecialty.addPatient(patient);
                //Overwrite old medical specialty for new with new patient added
                medicalSpecialty = medicalSpecialtyRepository.save(medicalSpecialty);

                return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
            }
        }
        date.setPatient(patient);
        patient.addDate(date);
        patient.setMedicalSpecialty(medicalSpecialty);
        patient.incrementNumberOfAppointment();
        medicalSpecialty.addPatient(patient);
        medicalSpecialtyRepository.save(medicalSpecialty);
        patientRepository.save(patient);
        return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
    }

    @Override
    public MedicalSpecialtyDTO updateMedicalSpecialty(Long id, MedicalSpecialtyDTO medicalSpecialtyDTO) {
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(getMedicalSpecialtyById(id));
        medicalSpecialty.setName(medicalSpecialtyDTO.getName());
        medicalSpecialty.setPhysicianInCharge(medicalSpecialtyDTO.getPhysicianInCharge());
        medicalSpecialtyRepository.save(medicalSpecialty);

        return medicalSpecialtyMapper.convertToDTO(medicalSpecialty);
    }

    @Override
    public void deleteMedicalSpecialty(Long id) {
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(getMedicalSpecialtyById(id));
        medicalSpecialtyRepository.delete(medicalSpecialty);
    }

    @Override
    public void deleteAllPatients(Long id) {
        MedicalSpecialty medicalSpecialty = medicalSpecialtyMapper.convertToEntity(getMedicalSpecialtyById(id));
        patientRepository.deleteAll(medicalSpecialty.getPatients());
    }
}
