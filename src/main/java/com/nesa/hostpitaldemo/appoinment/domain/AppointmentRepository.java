package com.nesa.hostpitaldemo.appoinment.domain;

import java.util.Optional;

public interface AppointmentRepository {
    Appoinment save(Appoinment appoinment);
    Optional<Appoinment> findById(Long id);
}
