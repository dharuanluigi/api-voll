package net.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String uf,
        String complement,
        String number
) {
}
