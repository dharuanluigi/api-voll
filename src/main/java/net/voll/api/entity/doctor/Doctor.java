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
    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;
}
