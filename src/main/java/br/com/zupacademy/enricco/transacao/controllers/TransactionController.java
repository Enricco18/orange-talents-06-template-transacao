package br.com.zupacademy.enricco.transacao.controllers;

import br.com.zupacademy.enricco.transacao.controllers.responses.TransactionDTO;
import br.com.zupacademy.enricco.transacao.models.PaymentCard;
import br.com.zupacademy.enricco.transacao.models.Transaction;
import br.com.zupacademy.enricco.transacao.repositories.PaymentCardRepository;
import br.com.zupacademy.enricco.transacao.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private PaymentCardRepository cardRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionDTO>> get10byPageTransaction(@PathVariable("id") String id){
        logger.info("GET | /transaction/{id} | "+ id);
        PaymentCard card = cardRepository.findById(id)
                                            .orElseThrow(
                                                    ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"not Found")
                                            );

        Pageable pageable = PageRequest.of(0,10, Sort.by("transactionDate").descending());
        List<Transaction> transactionList = transactionRepository.findAllByCard(card,pageable);

        List<TransactionDTO> response = transactionList.stream().map(transaction -> {
                                                    return new TransactionDTO(transaction);
                                                }).collect(Collectors.toList());

        return ResponseEntity.status(200).body(response);
    }
}
