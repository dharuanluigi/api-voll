package net.voll.api.entity.patient;

import net.voll.api.entity.AddressDTO;

public record PatientDTO(String name, String email, String phone, String cpf, AddressDTO addressDTO) {
}
