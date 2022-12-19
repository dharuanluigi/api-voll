package net.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.voll.api.entity.Patient;

public record UpdatePatientDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        @JsonProperty("address") @Valid
        AddressDTO addressDTO
) {
        public UpdatePatientDTO(Patient patient) {
                this(patient.getId(), patient.getName(), patient.getPhone(), new AddressDTO(patient.getAddress()));
        }
}
