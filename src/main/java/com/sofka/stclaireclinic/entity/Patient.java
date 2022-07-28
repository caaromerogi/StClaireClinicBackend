package com.sofka.stclaireclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "number_of_appointments", nullable = false)
    private int numberOfAppointments = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_specialty_id", nullable = false)
    private MedicalSpecialty medicalSpecialty;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Date> dates;

    public void incrementNumberOfAppointment(){
        this.numberOfAppointments += 1;
    }

    public void addDate(Date date){
        dates.add(date);
    }
}
