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
        String age,
        Long doctorId
) {
}
