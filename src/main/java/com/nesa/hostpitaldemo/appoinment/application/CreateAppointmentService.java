package com.nesa.hostpitaldemo.appoinment.application;

import com.nesa.hostpitaldemo.appoinment.domain.Appoinment;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentNumber;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentRepository;

public class CreateAppointmentService {
    private final AppointmentRepository repository;

    public CreateAppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appoinment create(String number, Long doctorId, Long patientId, Long userId) {
        Appoinment appoinment = new Appoinment(new AppointmentNumber(number), doctorId, patientId, userId);
        return repository.save(appoinment);
    }
}
