package com.nesa.hostpitaldemo.patient.infrastructure;

import com.nesa.hostpitaldemo.patient.domain.Patient;
import com.nesa.hostpitaldemo.patient.domain.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PatientRepoImpl implements PatientRepo {

    private final JpaPatientRepo jpaPatientRepo; // Injecting the Spring Data interface

    @Override
    public Patient save(Patient patient) {
        return jpaPatientRepo.save(patient);
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return jpaPatientRepo.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return jpaPatientRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaPatientRepo.deleteById(id);
    }
}
