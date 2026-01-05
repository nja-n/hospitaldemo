package com.nesa.hostpitaldemo.appoinment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesa.hostpitaldemo.appoinment.api.records.CreateAppointmentRequest;
import com.nesa.hostpitaldemo.appoinment.application.CreateAppointmentService;
import com.nesa.hostpitaldemo.appoinment.domain.Appointment;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final CreateAppointmentService createAppointmentService;

    public AppointmentController(CreateAppointmentService createAppointmentService) {
        this.createAppointmentService = createAppointmentService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<?> postAppointment(@RequestBody CreateAppointmentRequest entry) {
        Appointment appointment = createAppointmentService.create(entry);
        return ResponseEntity.ok(appointment);
    }
    
    
}
