package net.voll.api.entity.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.voll.api.entity.AddressDTO;

public record UpdateDoctorDTO(
        @NotNull
        Long id,
        String name,
        String phone,

        @JsonProperty("address") @Valid
        AddressDTO addressDTO
) {
}
