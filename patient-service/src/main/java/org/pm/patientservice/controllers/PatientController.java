package org.pm.patientservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pm.patientservice.Service.PatientService;
import org.pm.patientservice.dto.PatientRequestDto;
import org.pm.patientservice.dto.PatientResponseDto;
import org.pm.patientservice.exceptions.validator.CreateGroupForDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Tag(name="Patient",description = "API for patient Service")
@Slf4j
@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @Operation(description = "The api for retrieving the patients")
    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllAPatient(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }
    @Operation(description = "The api for creating the Patient")
    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Validated({Default.class, CreateGroupForDTO.class}) @RequestBody PatientRequestDto patientRequestDto){
        log.warn("gandu");
        return ResponseEntity.ok(patientService.createPatient(patientRequestDto));
    }

    @Operation(description = "the api for updating patient by using id")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto>updatePatient(@Validated(Default.class) @RequestBody PatientRequestDto patientRequestDto, @PathVariable UUID id){
        return ResponseEntity.ok().body(patientService.updatePatient(id,patientRequestDto));
    }

    @Operation(description = "The Api for deleting Patient")
    @DeleteMapping
    public ResponseEntity<PatientResponseDto>deletePatient(@PathVariable UUID id){
        return ResponseEntity.ok().body( patientService.deletePatient(id));
    }
}
