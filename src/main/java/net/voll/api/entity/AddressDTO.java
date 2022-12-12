package net.voll.api.entity;

public record AddressDTO(String logradouro, String neighborhood, String zipcode, String city, String uf, String complement, String number) {
}
