package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.entity.doctor.Doctor;
import net.voll.api.entity.doctor.DoctorDTO;
import net.voll.api.entity.doctor.response.ListAllDoctors;
import net.voll.api.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<ListAllDoctors> getAll(@PageableDefault(sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(ListAllDoctors::new);
    }
}
