package org.pm.patientservice.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pm.patientservice.Service.PatientService;
import org.pm.patientservice.dto.PatientRequestDto;
import org.pm.patientservice.dto.PatientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllAPatient(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }
    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        return ResponseEntity.ok(patientService.createPatient(patientRequestDto));
    }


}
