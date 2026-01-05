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
public class PatientRegDto {

    @JsonProperty("pName")
    private String pName;

    @JsonProperty("pAddress")
    private String pAddress;

    @JsonProperty("pMobile")
    private String pMobile;

    @JsonProperty("pAge")
    private Integer pAge;

    private String disease;

    private Long createdById;


}
