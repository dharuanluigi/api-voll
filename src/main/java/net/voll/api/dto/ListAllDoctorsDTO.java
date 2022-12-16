package net.voll.api.dto;

import net.voll.api.entity.Doctor;
import net.voll.api.enums.Speciality;

public record ListAllDoctorsDTO(Long id, String name, String email, String crm, Speciality speciality) {

    public ListAllDoctorsDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
