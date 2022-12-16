package net.voll.api.dto;

import net.voll.api.entity.Patient;

public record ListAllPatientsDTO(Long id, String name, String email, String cpf) {

    public ListAllPatientsDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
