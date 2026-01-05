package com.nesa.hostpitaldemo.appoinment.domain;

import java.time.LocalDateTime;

import com.nesa.hostpitaldemo.doctor.domain.Doctor;
import com.nesa.hostpitaldemo.patient.domain.Patient;

public class Appointment {
    private Long id;
    private AppointmentNumber number;
    private Doctor doctor ;
    private Patient patient;
    private LocalDateTime createdAt;
    // private User createdBy;
    private AppointmentStatus status;

    public Appointment(AppointmentNumber number, Long doctorId, Long patientId, Long userId) {
        this.number = number;
        this.status = AppointmentStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        // this.doctor = doctorId;
        // this.patient = patientId;
    }

    public void confirm() {
        if (status != AppointmentStatus.CREATED) {
            throw new IllegalStateException("Only CREATED appointments can be confirmed");
        }
        status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Completed appointment cannot be cancelled");
        }
        status = AppointmentStatus.CANCELLED;
    }

    public void complete() {
        if (status != AppointmentStatus.CONFIRMED) {
            throw new IllegalStateException("Only CONFIRMED appointments can be completed");
        }
        status = AppointmentStatus.COMPLETED;
    }

    public Long getId() {
        return id;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

}
