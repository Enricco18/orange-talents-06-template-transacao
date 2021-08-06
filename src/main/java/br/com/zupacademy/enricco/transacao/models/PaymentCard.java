package br.com.zupacademy.enricco.transacao.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Embeddable
public class PaymentCard {
    private String id;
    @Email
    private String email;

    @Deprecated
    private PaymentCard() {
    }

    public PaymentCard(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
