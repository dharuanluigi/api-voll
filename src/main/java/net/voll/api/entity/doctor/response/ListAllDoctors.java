package net.voll.api.entity.doctor.response;

import net.voll.api.entity.doctor.Doctor;
import net.voll.api.entity.doctor.enums.Speciality;

public record ListAllDoctors(Long id, String name, String email, String crm, Speciality speciality) {

    public ListAllDoctors(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
