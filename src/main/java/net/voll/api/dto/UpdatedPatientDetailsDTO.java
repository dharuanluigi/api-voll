package net.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.voll.api.entity.Patient;

public record UpdatedPatientDetailsDTO(
        Long id,
        String name,
        String email,
        String phone,
        @JsonProperty("address")
        AddressDTO address
) {
    public UpdatedPatientDetailsDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(),new AddressDTO(patient.getAddress()));
    }
}
