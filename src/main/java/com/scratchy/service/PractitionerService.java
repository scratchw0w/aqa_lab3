package com.scratchy.service;

import java.util.List;

import com.scratchy.entity.Practitioner;
import com.scratchy.repository.PractitionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PractitionerService {

  private final PractitionerRepository repository;

  public Practitioner getByLastName(String lastName) {
    return repository.findByLastName(lastName);
  }

  public void createPractitioner(Practitioner practitioner) {
    repository.save(practitioner);
  }

  public List<Practitioner> findAllPractitioners() {
    return repository.findAll();
  }
}
