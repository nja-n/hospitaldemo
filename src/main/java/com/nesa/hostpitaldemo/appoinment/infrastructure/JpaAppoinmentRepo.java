package com.nesa.hostpitaldemo.appoinment.infrastructure;

import java.util.Optional;

import com.nesa.hostpitaldemo.appoinment.domain.Appoinment;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentRepository;

public class JpaAppoinmentRepo implements AppointmentRepository{

    private final SpringDataAppoinmentRepo repository;

    public JpaAppoinmentRepo(SpringDataAppoinmentRepo repository) {
        this.repository = repository;
    }

    @Override
    public Appoinment save(Appoinment appoinment) {
        repository.save(appoinment);
        return appoinment;
    }

    @Override
    public Optional<Appoinment> findById(Long id) {
        return repository.findById(id);
    }
    
}
