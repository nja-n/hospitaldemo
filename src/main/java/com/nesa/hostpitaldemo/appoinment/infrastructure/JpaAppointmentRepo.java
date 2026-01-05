package com.nesa.hostpitaldemo.appoinment.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nesa.hostpitaldemo.appoinment.domain.Appointment;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentRepository;
import com.nesa.hostpitaldemo.appoinment.infrastructure.entities.AppointmentEntity;
import com.nesa.hostpitaldemo.appoinment.infrastructure.repos.SpringDataAppointmentRepo;
import com.nesa.hostpitaldemo.common.utils.Mapper;

@Repository
public class JpaAppointmentRepo implements AppointmentRepository {

    private final SpringDataAppointmentRepo repository;
    private final Mapper<Appointment, AppointmentEntity> mapper;

    public JpaAppointmentRepo(SpringDataAppointmentRepo repository, Mapper<Appointment, AppointmentEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Appointment save(Appointment Appointment) {
        AppointmentEntity entity = mapper.toEntity(Appointment);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

}
