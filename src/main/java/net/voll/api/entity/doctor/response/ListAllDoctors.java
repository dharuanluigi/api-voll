package net.voll.api.entity.doctor.response;

import net.voll.api.entity.doctor.Doctor;
import net.voll.api.entity.doctor.enums.Speciality;

public record ListAllDoctors(String name, String email, String crm, Speciality speciality) {

    public ListAllDoctors(Doctor doctor){
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
