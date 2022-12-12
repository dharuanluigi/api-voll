package net.voll.api.entity.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.voll.api.entity.Address;
import net.voll.api.entity.doctor.enums.Speciality;

@Entity
@Table(name = "tb_doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String phone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.phone = doctorDTO.phone();
        this.crm = doctorDTO.crm();
        this.speciality = doctorDTO.speciality();
        this.address = new Address(doctorDTO.addressDTO());
    }
}
