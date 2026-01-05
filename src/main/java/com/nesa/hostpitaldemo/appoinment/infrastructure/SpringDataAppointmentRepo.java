package com.nesa.hostpitaldemo.appoinment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nesa.hostpitaldemo.appoinment.infrastructure.entities.AppointmentEntity;

@Repository
public interface SpringDataAppointmentRepo extends JpaRepository<AppointmentEntity, Long> {

}
