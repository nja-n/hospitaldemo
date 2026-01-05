package com.nesa.hostpitaldemo.appoinment.infrastructure.entities;

import java.time.LocalDateTime;

import com.nesa.hostpitaldemo.appoinment.domain.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "appointments")
@Entity
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Long doctorId;
    private Long patientId;
    private Long userId;
    private LocalDateTime createdAt;
    private AppointmentStatus status;
}
