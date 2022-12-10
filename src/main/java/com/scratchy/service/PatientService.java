package com.scratchy.service;

import java.util.List;

import com.scratchy.entity.Patient;
import com.scratchy.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

  private final PatientRepository repository;

  public List<Patient> getAllPatients() {
    return repository.findAll();
  }

  public Patient getPatientBySurname(String lastName) {
    return repository.findByLastName(lastName);
  }

  public void createPatient(Patient patient) {
    repository.save(patient);
  }
}
