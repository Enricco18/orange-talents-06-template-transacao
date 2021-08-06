package br.com.zupacademy.enricco.transacao.messages.models;

import br.com.zupacademy.enricco.transacao.models.Institution;
import br.com.zupacademy.enricco.transacao.models.PaymentCard;
import br.com.zupacademy.enricco.transacao.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionEvent {
    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private Estabelecimento estabelecimento;
    private Cartao cartao;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public String getCartao_Id(){
        return this.cartao.id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    @Override
    public String toString() {
        return "TransactionEvent{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                '}';
    }

    public Transaction toModel() {
        PaymentCard paymentCard = cartao.toModel();
        Institution institution = estabelecimento.toModel();
        return new Transaction(UUID.fromString(id),valor,efetivadaEm,institution,paymentCard);
    }

    public class Estabelecimento{
        private String nome;
        private String cidade;
        private String endereco;

        public String getNome() {
            return nome;
        }

        public String getCidade() {
            return cidade;
        }

        public String getEndereco() {
            return endereco;
        }

        public Institution toModel() {
            return new Institution(nome,cidade,endereco);
        }
    }

    public class Cartao{
        private String id;
        private String email;

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public PaymentCard toModel() {
            return new PaymentCard(id,email);
        }
    }
}
