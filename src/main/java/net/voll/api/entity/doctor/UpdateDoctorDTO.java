package net.voll.api.entity.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.voll.api.entity.AddressDTO;

public record UpdateDoctorDTO(
        @NotNull
        Long id,
        String name,
        String phone,

        @Valid
        AddressDTO addressDTO
) {
}
