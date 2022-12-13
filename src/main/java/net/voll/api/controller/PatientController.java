package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.entity.patient.Patient;
import net.voll.api.entity.patient.PatientDTO;
import net.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid PatientDTO patientDTO) {
        repository.save(new Patient(patientDTO));
    }
}
