package com.nesa.hostpitaldemo.patient.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientUpdateDto {

    private Long id;

    @JsonProperty("pName") // Forces Jackson to match this exact JSON key
    private String pName;

    @JsonProperty("pAddress")
    private String pAddress;

    @JsonProperty("pMobile")
    private String pMobile;

    @JsonProperty("pAge")
    private Integer pAge;

    private String disease; // Normal names usually work fine
    private Long updatedById;
}
