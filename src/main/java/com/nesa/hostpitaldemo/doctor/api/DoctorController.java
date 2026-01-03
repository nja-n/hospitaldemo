package com.nesa.hostpitaldemo.doctor.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesa.hostpitaldemo.doctor.application.DoctorService;
import com.nesa.hostpitaldemo.doctor.domain.Doctor;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{number}/availability")
    public ResponseEntity<Boolean> getAvailability(@PathVariable String number) {
        return ResponseEntity.ok(doctorService.checkAvailability(number));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody DoctorRequest request) {
        Doctor doctor = new Doctor(new com.nesa.hostpitaldemo.doctor.domain.DoctorNumber(request.number()),
                request.name());
        doctorService.save(doctor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{number}")
    public ResponseEntity<Boolean> get(@PathVariable String number) {
        return ResponseEntity.ok(doctorService.checkAvailability(number));
    }

}
