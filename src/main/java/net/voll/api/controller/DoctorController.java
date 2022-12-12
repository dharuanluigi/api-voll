package net.voll.api.controller;

import net.voll.api.entity.doctor.Doctor;
import net.voll.api.entity.doctor.DoctorDTO;
import net.voll.api.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody DoctorDTO doctorDTO) {
        repository.save(new Doctor(doctorDTO));
    }
}
