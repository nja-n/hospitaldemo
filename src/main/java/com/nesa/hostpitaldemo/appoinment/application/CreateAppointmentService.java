package com.nesa.hostpitaldemo.appoinment.application;

import org.springframework.stereotype.Service;

import com.nesa.hostpitaldemo.appoinment.api.records.CreateAppointmentRequest;
import com.nesa.hostpitaldemo.appoinment.domain.Appointment;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentNumber;
import com.nesa.hostpitaldemo.appoinment.domain.AppointmentRepository;
import com.nesa.hostpitaldemo.patient.application.PatientService;
import com.nesa.hostpitaldemo.patient.domain.Patient;
import com.nesa.hostpitaldemo.patient.domain.PatientStatus;

@Service
public class CreateAppointmentService {
    private final AppointmentRepository repository;
    private final PatientService patientService;

    public CreateAppointmentService(AppointmentRepository repository, PatientService patientService) {
        this.repository = repository;
        this.patientService = patientService;
    }

    public Appointment create(CreateAppointmentRequest request) {
        Long doctorId = request.doctorId();
        Long patientId = request.patientId();
        if (request.patientId() == null) {
            Patient patient = new Patient(request.name(), request.address() + request.place(), request.mobile(),
                    request.age(), request.disease(), PatientStatus.NEW);
            patient = patientService.registerPatient(patient);
            patientId = patient.getId();
        } 
        Appointment Appointment = new Appointment(new AppointmentNumber("number"), doctorId, patientId, null);
        return repository.save(Appointment);
    }
}
