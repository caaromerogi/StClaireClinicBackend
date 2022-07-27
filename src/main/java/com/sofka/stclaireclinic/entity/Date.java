package com.sofka.stclaireclinic.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "date")
@Data
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

}

