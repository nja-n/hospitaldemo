package com.nesa.hostpitaldemo.patient.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends AuditData{


    private String pName;
    private String pAddress;
    private String pMobile;
    private Integer pAge;
    private String disease;

    @Enumerated(EnumType.STRING)
    private PatientStatus pStatus;


}
