package br.com.zupacademy.enricco.transacao.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tableTransaction")
public class Transaction {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "name", column = @Column(name = "institution_name")),
            @AttributeOverride(name = "city", column = @Column(name = "institution_city")),
            @AttributeOverride(name = "address", column = @Column(name = "institution_address"))
    })
    private Institution institution;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name = "paymentcard_id")),
            @AttributeOverride(name = "email", column = @Column(name = "paymentcard_email"))
    })
    private PaymentCard card;

    @Deprecated
    private Transaction() {
    }

    public Transaction(UUID id, BigDecimal value, LocalDateTime transactionDate, Institution institution, PaymentCard card) {
        this.id = id;
        this.value = value;
        this.transactionDate = transactionDate;
        this.institution = institution;
        this.card = card;
    }
}
