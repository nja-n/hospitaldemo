package com.nesa.hostpitaldemo.doctor.infrastructure;

import com.nesa.hostpitaldemo.doctor.domain.Doctor;
import com.nesa.hostpitaldemo.doctor.domain.DoctorNumber;
import com.nesa.hostpitaldemo.doctor.domain.DoctorRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaDoctorRepo implements DoctorRepo {
    private final SpringDataDoctorRepo springDataRepo;

    public JpaDoctorRepo(SpringDataDoctorRepo springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Optional<Doctor> findByNumber(DoctorNumber number) {
        // Mapping from Database Entity to Domain Object
        return springDataRepo.findByDoctorNumber(number.getNumber())
                .map(entity -> new Doctor(new DoctorNumber(entity.getDoctorNumber()), entity.getName()));
    }

    @Override
    public void save(Doctor doctor) {
        DoctorEntity entity = springDataRepo.findByDoctorNumber(doctor.getDoctorNumber().getNumber())
                .orElse(new DoctorEntity());

        entity.setDoctorNumber(doctor.getDoctorNumber().getNumber());
        entity.setName(doctor.getName()); // Assuming getter exists in Doctor
        entity.setStatus(doctor.isAvailable() ? "AVAILABLE" : "BUSY"); // Simple mapping

        springDataRepo.save(entity);
    }
}
