package com.nesa.hostpitaldemo.doctor.application;

import com.nesa.hostpitaldemo.doctor.domain.Doctor;
import com.nesa.hostpitaldemo.doctor.domain.DoctorNumber;
import com.nesa.hostpitaldemo.doctor.domain.DoctorRepo;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public boolean checkAvailability(String doctorNum) {
        return doctorRepo.findByNumber(new DoctorNumber(doctorNum))
                .map(Doctor::isAvailable)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor getDoctorByNumber(String number) {
        // We wrap the raw String in a Value Object to ensure domain integrity
        DoctorNumber doctorNum = new DoctorNumber(number);

        return doctorRepo.findByNumber(doctorNum)
                .orElseThrow(() -> new RuntimeException("Doctor with number " + number + " not found"));
    }

    public void save(Doctor doctor) {
        doctorRepo.save(doctor);
    }
}