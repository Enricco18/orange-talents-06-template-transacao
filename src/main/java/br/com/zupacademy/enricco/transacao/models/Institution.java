package br.com.zupacademy.enricco.transacao.models;

import javax.persistence.Embeddable;

@Embeddable
public class Institution {
    private String name;
    private String city;
    private String address;

    @Deprecated
    private Institution() {
    }

    public Institution(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
