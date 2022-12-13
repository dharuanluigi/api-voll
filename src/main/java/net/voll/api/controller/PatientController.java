package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.entity.patient.Patient;
import net.voll.api.entity.patient.PatientDTO;
import net.voll.api.entity.patient.UpdatePatientDTO;
import net.voll.api.entity.patient.response.ListAllPatients;
import net.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<ListAllPatients> getAll(@PageableDefault(sort = "name") Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(ListAllPatients::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody UpdatePatientDTO updatePatientDTO) {
        var patient = repository.getReferenceById(updatePatientDTO.id());
        patient.updateData(updatePatientDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactivate();
    }
}
