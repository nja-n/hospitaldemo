package com.nesa.hostpitaldemo.appoinment.infrastructure.entities;

import com.nesa.hostpitaldemo.appoinment.domain.AppointmentStatus;
import com.nesa.hostpitaldemo.patient.domain.AuditData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Table(name = "appointments")
@Entity
@Builder
public class AppointmentEntity extends AuditData{
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    private String number;
    private Long doctorId;
    private Long patientId;
    private Long userId;
    private AppointmentStatus status;
}
