package com.nesa.hostpitaldemo.appoinment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesa.hostpitaldemo.appoinment.api.records.CreateAppointmentRequest;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PostMapping("/appointment")
    public ResponseEntity<?> postAppointment(@RequestBody CreateAppointmentRequest entry) {
        System.out.println(entry);
        return ResponseEntity.ok(entry);
    }
    
    
}
