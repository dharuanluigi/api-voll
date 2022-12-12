package net.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logradouro;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(AddressDTO addressDTO) {
        this.logradouro = addressDTO.logradouro();
        this.neighborhood = addressDTO.neighborhood();
        this.zipcode = addressDTO.zipcode();
        this.city = addressDTO.city();
        this.uf = addressDTO.uf();
        this.complement = addressDTO.complement();
        this.number = addressDTO.number();
    }
}
