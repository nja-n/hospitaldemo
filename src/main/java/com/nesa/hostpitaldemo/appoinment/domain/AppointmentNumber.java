package com.nesa.hostpitaldemo.appoinment.domain;

import java.util.Objects;

public final class AppointmentNumber {
    private final String number;

    public AppointmentNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Appointment number cannot be empty");
        }
        this.number = number;
    }
    
    public String getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentNumber that = (AppointmentNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
