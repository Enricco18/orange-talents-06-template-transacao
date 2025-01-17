package br.com.zupacademy.enricco.transacao.messages.consumers;

import br.com.zupacademy.enricco.transacao.messages.models.TransactionEvent;
import br.com.zupacademy.enricco.transacao.models.PaymentCard;
import br.com.zupacademy.enricco.transacao.models.Transaction;
import br.com.zupacademy.enricco.transacao.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class SaveTransactions {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager manager;

    @KafkaListener(topics = "${transaction.topic.name}")
    @Transactional
    public void listen(TransactionEvent transactionEvent) {
        logger.info(transactionEvent.toString());
        PaymentCard card = manager.find(PaymentCard.class,transactionEvent.getCartao_Id());

        if(card==null){
            card = new PaymentCard(transactionEvent.getCartao_Id(),transactionEvent.getCartaoEmail());
            manager.persist(card);
        }

        Transaction transaction = transactionEvent.toModel(card);

        manager.persist(transaction);
    }
}
