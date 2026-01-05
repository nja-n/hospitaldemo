package com.nesa.hostpitaldemo.patient.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // This tells JPA this class is NOT a table, but its fields will be in other tables
@EntityListeners(AuditingEntityListener.class) // Triggers the automatic timestamping
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Remove @CreatedBy to allow manual setting from DTO
    @Column(updatable = false)
    private Long createdById;

    private Long updatedById;

    @CreatedDate // Keep this! It handles the time automatically
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate // Keep this!
    private LocalDateTime updatedOn;
}
