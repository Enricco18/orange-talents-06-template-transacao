package br.com.zupacademy.enricco.transacao.repositories;

import br.com.zupacademy.enricco.transacao.models.PaymentCard;
import br.com.zupacademy.enricco.transacao.models.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, UUID> {
    public List<Transaction> findAllByCard(PaymentCard card, Pageable pageable);
}
