package com.sofka.stclaireclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medical_specialty")
@Data
public class MedicalSpecialty {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "physician_in_charge", nullable = false)
    private String physicianInCharge;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalSpecialty")
    private List<Patient> patients = new ArrayList<>();

    public MedicalSpecialty addPatient(Patient patient){
        patients.add(patient);
        return this;
    }

    public MedicalSpecialty removePatient(Patient patient) {
        patients.remove(patient);
        return this;
    }
}
