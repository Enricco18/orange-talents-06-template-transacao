package br.com.zupacademy.enricco.transacao.repositories;

import br.com.zupacademy.enricco.transacao.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {
}
