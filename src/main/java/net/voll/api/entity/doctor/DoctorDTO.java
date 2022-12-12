package net.voll.api.entity.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.voll.api.entity.AddressDTO;
import net.voll.api.entity.doctor.enums.Speciality;

public record DoctorDTO(String name, String email, String crm, Speciality speciality, @JsonProperty("address") AddressDTO addressDTO) {
}
