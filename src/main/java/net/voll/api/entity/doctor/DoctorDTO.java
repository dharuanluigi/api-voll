package net.voll.api.entity.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import net.voll.api.entity.AddressDTO;
import net.voll.api.entity.doctor.enums.Speciality;

public record DoctorDTO(

        @NotBlank
        String name,
        @NotBlank @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Speciality speciality,
        @JsonProperty("address") @NotNull @Valid
        AddressDTO addressDTO
) {
}
