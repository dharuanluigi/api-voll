package net.voll.api.entity.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import net.voll.api.entity.AddressDTO;

public record PatientDTO(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @JsonProperty("address") @NotNull @Valid
        AddressDTO addressDTO
) {
}
