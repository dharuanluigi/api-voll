package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.dto.*;
import net.voll.api.entity.Doctor;
import net.voll.api.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<CreatedDoctorDTO> register(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriBuilder) {
        var doctor = repository.save(new Doctor(doctorDTO));
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreatedDoctorDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllDoctorsDTO>> getAll(@PageableDefault(sort = {"name"}) Pageable pagination) {
        var foundedDoctors = repository.findAllByActiveTrue(pagination).map(ListAllDoctorsDTO::new);
        return ResponseEntity.ok(foundedDoctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdatedDoctorDetailsDTO> getById(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new UpdatedDoctorDetailsDTO(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UpdatedDoctorDetailsDTO> update(@RequestBody @Valid UpdateDoctorDTO updateDoctorDTO) {
        var doctor = repository.getReferenceById(updateDoctorDTO.id());
        doctor.updateData(updateDoctorDTO);
        return ResponseEntity.ok(new UpdatedDoctorDetailsDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.inactive();
        return ResponseEntity.noContent().build();
    }
}
