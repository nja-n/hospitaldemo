package com.nesa.hostpitaldemo.doctor.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpringDataDoctorRepo extends JpaRepository<DoctorEntity, Long> {
    Optional<DoctorEntity> findByDoctorNumber(String doctorNumber);
}
