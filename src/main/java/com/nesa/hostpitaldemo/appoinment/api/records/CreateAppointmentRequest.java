package com.nesa.hostpitaldemo.appoinment.api.records;

public record CreateAppointmentRequest(
        String number,
        String name,
        String place,
        String address,
        String proof,
        String proofId,
        String disease,
        String mobile,
        Integer age,
        Long doctorId,
        Long patientId
) {
}
