package com.nesa.hostpitaldemo.doctor.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;

@Getter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final DoctorNumber doctorNumber; // Value Object
    private String name;
    private DoctorStatus status; // Enum: AVAILABLE, BUSY, AWAY

    public Doctor(DoctorNumber doctorNumber, String name) {
        this.doctorNumber = doctorNumber;
        this.name = name;
        this.status = DoctorStatus.AVAILABLE;
    }

    // Business Logic: Only the Aggregate handles its own state (Encapsulation)
    public boolean isAvailable() {
        return this.status == DoctorStatus.AVAILABLE;
    }

    public void markAsBusy() {
        this.status = DoctorStatus.BUSY;
    }

    public DoctorNumber getDoctorNumber() {
        return doctorNumber;
    }

    public String getName() {
        return name;
    }
}