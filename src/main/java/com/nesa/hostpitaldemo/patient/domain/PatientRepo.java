package com.nesa.hostpitaldemo.patient.domain;

import java.util.List;
import java.util.Optional;

public interface PatientRepo {

    Patient save(Patient patient);

    Optional<Patient> findById(Long id);

    List<Patient> findAll();

    void deleteById(Long id);
}
