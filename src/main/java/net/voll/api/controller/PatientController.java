package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.dto.CreatedPatientDTO;
import net.voll.api.entity.Patient;
import net.voll.api.dto.PatientDTO;
import net.voll.api.dto.UpdatePatientDTO;
import net.voll.api.dto.ListAllPatientsDTO;
import net.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<CreatedPatientDTO> register(@RequestBody @Valid PatientDTO patientDTO, UriComponentsBuilder uriBuilder) {
        var patient = repository.save(new Patient(patientDTO));
        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreatedPatientDTO(patient));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllPatientsDTO>> getAll(@PageableDefault(sort = "name") Pageable pagination) {
        var allPatients = repository.findAllByActiveTrue(pagination).map(ListAllPatientsDTO::new);
        return ResponseEntity.ok(allPatients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdatePatientDTO> getById(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        return ResponseEntity.ok(new UpdatePatientDTO(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UpdatePatientDTO> update(@RequestBody UpdatePatientDTO updatePatientDTO) {
        var patient = repository.getReferenceById(updatePatientDTO.id());
        patient.updateData(updatePatientDTO);
        return ResponseEntity.ok(new UpdatePatientDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactivate();
        return ResponseEntity.noContent().build();
    }
}
