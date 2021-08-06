package br.com.zupacademy.enricco.transacao.controllers.responses;

import br.com.zupacademy.enricco.transacao.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private BigDecimal value;
    private LocalDateTime transaction_date;
    private String institution_name;

    public TransactionDTO(Transaction transaction) {
        this.value = transaction.getValue();
        this.transaction_date =  transaction.getTransactionDate();
        this.institution_name = transaction.getInstitutionName();
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public String getInstitution_name() {
        return institution_name;
    }
}
