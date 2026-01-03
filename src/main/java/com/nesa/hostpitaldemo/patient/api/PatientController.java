package com.nesa.hostpitaldemo.patient.api;

import com.nesa.hostpitaldemo.patient.application.PatientService;
import com.nesa.hostpitaldemo.patient.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/Register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        Patient patient = patientService.findPatientById(id);
        return ResponseEntity.ok(patient);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

}
