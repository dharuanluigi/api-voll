package net.voll.api.entity.doctor;

import net.voll.api.entity.AddressDTO;
import net.voll.api.entity.doctor.enums.Speciality;

public record DoctorDTO(String name, String email, String crm, Speciality speciality, AddressDTO addressDTO) {
}
