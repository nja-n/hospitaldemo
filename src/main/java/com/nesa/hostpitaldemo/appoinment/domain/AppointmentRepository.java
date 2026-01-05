package com.nesa.hostpitaldemo.appoinment.domain;

import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment Appointment);

    Optional<Appointment> findById(Long id);
}
