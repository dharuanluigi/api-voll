package net.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorDTO(
        @NotNull
        Long id,
        String name,
        String phone,

        @JsonProperty("address") @Valid
        AddressDTO addressDTO
) {
}
