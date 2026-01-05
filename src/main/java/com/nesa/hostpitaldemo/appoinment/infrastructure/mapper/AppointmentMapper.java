package com.nesa.hostpitaldemo.appoinment.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.nesa.hostpitaldemo.appoinment.domain.Appointment;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentNumber;
import com.nesa.hostpitaldemo.appoinment.infrastructure.entities.AppointmentEntity;
import com.nesa.hostpitaldemo.common.utils.Mapper;

@Component
public class AppointmentMapper implements Mapper<Appointment, AppointmentEntity> {
    
    @Override
    public AppointmentEntity toEntity(Appointment domain) {
        return AppointmentEntity.builder()
                // .id(domain.getId())
                .number(domain.getNumber().getValue())
                .doctorId(domain.getDoctor())
                .patientId(domain.getPatient())
                // .createdAt(domain.getCreatedAt())
                .status(domain.getStatus())
                .build();
    }

    @Override
    public Appointment toDomain(AppointmentEntity entity) {
        return Appointment.builder()
                .id(entity.getId())
                .number(new AppointmentNumber(entity.getNumber()))
                .doctor(entity.getDoctorId())
                .patient(entity.getPatientId())
                // .createdAt(entity.getCreatedAt())
                .status(entity.getStatus())
                .build();
    }
}
