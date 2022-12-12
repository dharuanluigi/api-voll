package net.voll.api.controller;

import net.voll.api.entity.patient.PatientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping
    public void insert(@RequestBody PatientDTO patientDTO) {
        System.out.println(patientDTO);
    }
}
