package net.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.voll.api.entity.Doctor;
import net.voll.api.enums.Speciality;

public record UpdatedDoctorDetailsDTO(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Speciality speciality,

        @JsonProperty("address")
        AddressDTO address
) {
    public UpdatedDoctorDetailsDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpeciality(), new AddressDTO(doctor.getAddress()));
    }
}
