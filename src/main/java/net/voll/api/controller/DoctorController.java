package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.entity.Doctor;
import net.voll.api.dto.DoctorDTO;
import net.voll.api.dto.UpdateDoctorDTO;
import net.voll.api.dto.ListAllDoctorsDTO;
import net.voll.api.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorDTO doctorDTO) {
        repository.save(new Doctor(doctorDTO));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllDoctorsDTO>> getAll(@PageableDefault(sort = {"name"}) Pageable pagination) {
        var foundedDoctors = repository.findAllByActiveTrue(pagination).map(ListAllDoctorsDTO::new);
        return ResponseEntity.ok(foundedDoctors);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorDTO updateDoctorDTO) {
        var doctor = repository.getReferenceById(updateDoctorDTO.id());
        doctor.updateData(updateDoctorDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.inactive();
        return ResponseEntity.noContent().build();
    }
}
