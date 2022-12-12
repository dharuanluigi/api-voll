package net.voll.api.controller;

import net.voll.api.entity.doctor.DoctorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void register(@RequestBody DoctorDTO doctorDTO) {
        System.out.println(doctorDTO);
    }
}
