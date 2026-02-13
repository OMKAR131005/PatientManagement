package org.pm.patientservice.mapper;

import org.pm.patientservice.dto.PatientRequestDto;
import org.pm.patientservice.dto.PatientResponseDto;
import org.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDto patientToDto(Patient patient){
        PatientResponseDto dto=new PatientResponseDto();
        dto.setId(patient.getId().toString());
        dto.setAddress(patient.getAddress());
        dto.setEmail(patient.getEmail());
        dto.setDateOfBirth(patient.getDateOfBirth().toString());
        dto.setName(patient.getName());
        return dto;
    }
    public static  Patient toModel(PatientRequestDto patientRequestDto){
        Patient patient=new Patient();
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDto.getRegistrationDate()));
        patient.setName(patientRequestDto.getName());
        return patient;
    }
}
