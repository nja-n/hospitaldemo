package com.nesa.hostpitaldemo.doctor.domain;

import java.util.Optional;

// domain/DoctorRepo.java
public interface DoctorRepo {
    Optional<Doctor> findByNumber(DoctorNumber number);

    void save(Doctor doctor);
}