package com.nesa.hostpitaldemo.appoinment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesa.hostpitaldemo.appoinment.domain.Appoinment;

public interface SpringDataAppoinmentRepo extends JpaRepository<Appoinment, Long>{
    
}
