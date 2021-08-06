package br.com.zupacademy.enricco.transacao.repositories;

import br.com.zupacademy.enricco.transacao.models.PaymentCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCardRepository extends CrudRepository<PaymentCard,String> {
}
