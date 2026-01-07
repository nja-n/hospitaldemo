package com.nesa.hostpitaldemo.patient.application;


import com.nesa.hostpitaldemo.patient.application.dto.PatientRegDto;
import com.nesa.hostpitaldemo.patient.application.dto.PatientUpdateDto;
import com.nesa.hostpitaldemo.patient.domain.Patient;
import com.nesa.hostpitaldemo.patient.domain.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;



    @Transactional
    public Patient registerPatient(PatientRegDto dto) {

        Patient patient = Patient.builder()
                .pName(dto.getPName())
                .pAddress(dto.getPAddress())
                .pMobile(dto.getPMobile())
                .pAge(dto.getPAge())
                .disease(dto.getDisease())
                .build();
        patient.setCreatedById(dto.getCreatedById());
        patient.setCreatedOn(LocalDateTime.now());

        return patientRepo.save(patient);
    }

    @Transactional(readOnly = true)
    public Patient findPatientById(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found with ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Transactional
    public Patient updatePatient(PatientUpdateDto patientUpdDto){

        Patient existingPatient = patientRepo.findById(patientUpdDto.getId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientUpdDto.getId()));
        if (patientUpdDto.getPName()!=null)existingPatient.setPName(patientUpdDto.getPName());
        if (patientUpdDto.getDisease()!=null)existingPatient.setDisease(patientUpdDto.getDisease());
        if (patientUpdDto.getPAge()!=null)existingPatient.setPAge(patientUpdDto.getPAge());
        if (patientUpdDto.getPMobile()!=null)existingPatient.setPMobile(patientUpdDto.getPMobile());
        if (patientUpdDto.getPAddress()!=null)existingPatient.setPAddress(patientUpdDto.getPAddress());

        existingPatient.setUpdatedOn(LocalDateTime.now());
        existingPatient.setUpdatedById(patientUpdDto.getUpdatedById());
        return patientRepo.save(existingPatient);
    }


}
