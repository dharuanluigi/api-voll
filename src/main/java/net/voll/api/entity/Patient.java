package net.voll.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import net.voll.api.dto.PatientDTO;
import net.voll.api.dto.UpdatePatientDTO;

@Entity
@Table(name = "tb_patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String cpf;

    @Embedded
    private Address address;

    private Boolean active;

    public Patient(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.phone = patientDTO.phone();
        this.cpf = patientDTO.cpf();
        this.address = new Address(patientDTO.addressDTO());
        this.active = true;
    }

    public void updateData(UpdatePatientDTO updatePatientDTO) {
        if(updatePatientDTO.name() != null) {
            this.name = updatePatientDTO.name();
        }

        if(updatePatientDTO.phone() != null) {
            this.phone = updatePatientDTO.phone();
        }

        if(updatePatientDTO.addressDTO() != null) {
            this.address.updateData(updatePatientDTO.addressDTO());
        }
    }

    public void inactivate() {
        this.active = false;
    }
}
