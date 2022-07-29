package com.sofka.stclaireclinic.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    private Long dni;

    @Column(name = "number_of_appointments", nullable = false)
    private Long numberOfAppointments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_specialty_id", nullable = false)
    private MedicalSpecialty medicalSpecialty;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Date> dates = new ArrayList<>();

    public void incrementNumberOfAppointment(){
        if(this.numberOfAppointments ==null){
            setNumberOfAppointments(1L);
        }else {
            this.numberOfAppointments += 1L;
        }
    }

    public void addDate(Date date){
        dates.add(date);
    }
}
