package org.pm.patientservice.Service;

import org.pm.patientservice.Repository.PatientRepository;
import org.pm.patientservice.dto.PatientRequestDto;
import org.pm.patientservice.dto.PatientResponseDto;
import org.pm.patientservice.exceptions.EmailDuplicateException;
import org.pm.patientservice.mapper.PatientMapper;
import org.pm.patientservice.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
}
