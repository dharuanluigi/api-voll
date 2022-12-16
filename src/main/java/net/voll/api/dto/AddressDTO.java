package net.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import net.voll.api.entity.Address;

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
        public AddressDTO(Address address) {
                this(address.getLogradouro(), address.getNeighborhood(), address.getZipcode(), address.getCity(), address.getUf(), address.getComplement(), address.getNumber());
        }
}
