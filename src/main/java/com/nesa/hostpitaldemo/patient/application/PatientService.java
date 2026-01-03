package com.nesa.hostpitaldemo.patient.application;


import com.nesa.hostpitaldemo.patient.domain.Patient;
import com.nesa.hostpitaldemo.patient.domain.PatientRepo;
import com.nesa.hostpitaldemo.patient.domain.PatientStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;


    @Transactional
    public Patient registerPatient(Patient patient) {
        patient.setPStatus(PatientStatus.valueOf(PatientStatus.NEW.name()));
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

    /**
     * Updates patient disease/status (Domain logic trigger)
     */
    @Transactional
    public Patient updatePatientDisease(Long id, String disease) {
        Patient patient = findPatientById(id);
        patient.setDisease(disease);
        // Business Rule: Once a disease is assigned, they are waiting for consultation
        patient.setPStatus(PatientStatus.valueOf(PatientStatus.WAITING.name()));
        return patientRepo.save(patient);
    }

}
