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

    public void updateData(AddressDTO addressDTO) {
        if(addressDTO.logradouro() != null) {
            this.logradouro = addressDTO.logradouro();
        }

        if(addressDTO.neighborhood() != null) {
            this.neighborhood = addressDTO.neighborhood();
        }

        if(addressDTO.zipcode() != null) {
            this.zipcode = addressDTO.zipcode();
        }

        if(addressDTO.city() != null) {
            this.city = addressDTO.city();
        }

        if(addressDTO.uf() != null) {
            this.uf = addressDTO.uf();
        }

        if(addressDTO.complement() != null) {
            this.complement = addressDTO.complement();
        }

        if(addressDTO.number() != null) {
            this.number = addressDTO.number();
        }
    }
}
