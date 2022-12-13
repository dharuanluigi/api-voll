package net.voll.api.entity.patient.response;

import net.voll.api.entity.patient.Patient;

public record ListAllPatients(Long id, String name, String email, String cpf) {

    public ListAllPatients(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
