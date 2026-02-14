package org.pm.patientservice.Service;

import org.pm.patientservice.Repository.PatientRepository;
import org.pm.patientservice.dto.PatientRequestDto;
import org.pm.patientservice.dto.PatientResponseDto;
import org.pm.patientservice.exceptions.EmailDuplicateException;
import org.pm.patientservice.exceptions.PatientNotFoundException;
import org.pm.patientservice.mapper.PatientMapper;
import org.pm.patientservice.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class PatientService {
    private PatientRepository repository;
    public PatientService(PatientRepository repository){
        this.repository=repository;
    }
    public List<PatientResponseDto> getAllPatients(){
        List<Patient>patientList=repository.findAll();
        List<PatientResponseDto>pList=patientList.stream().map (PatientMapper::patientToDto).toList();
        return pList;
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto ){
        if(repository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailDuplicateException("email is already use");
        }
        Patient patient=PatientMapper.toModel(patientRequestDto);
        repository.save(patient);
        return PatientMapper.patientToDto(patient);

    }
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){
        Patient patient=repository.findById(id).orElseThrow(()->new PatientNotFoundException("patient with the id "+id+"not found"));
        if(repository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailDuplicateException("email is already is use");
        }
        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setEmail(patientRequestDto.getEmail());
        return PatientMapper.patientToDto(patient);

    }
}
