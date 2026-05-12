package com.simpleledger.simpleledger.repository;

import com.simpleledger.simpleledger.model.Transaction;
import com.simpleledger.simpleledger.model.Transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByType(TransactionType type);

    List<Transaction> findTop5ByOrderByTransactionDateDescCreatedAtDesc();
}