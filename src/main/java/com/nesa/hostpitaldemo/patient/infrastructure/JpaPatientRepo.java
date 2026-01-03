package com.nesa.hostpitaldemo.patient.infrastructure;

import com.nesa.hostpitaldemo.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPatientRepo extends JpaRepository<Patient, Long>{

}
