package com.sofka.stclaireclinic.respository;

import com.sofka.stclaireclinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
