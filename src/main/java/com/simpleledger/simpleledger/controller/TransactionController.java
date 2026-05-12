package com.simpleledger.simpleledger.controller;

import com.simpleledger.simpleledger.model.Transaction;
import com.simpleledger.simpleledger.model.Transaction.TransactionType;
import com.simpleledger.simpleledger.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalIncome", transactionService.getTotalIncome());
        model.addAttribute("totalExpenses", transactionService.getTotalExpenses());
        model.addAttribute("balance", transactionService.getBalance());
        model.addAttribute("transactionCount", transactionService.getTransactionCount());
        model.addAttribute("recentTransactions", transactionService.getRecentTransactions());

        return "dashboard";
    }

    @GetMapping("/transactions")
    public String transactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transactions";
    }

    @GetMapping("/transactions/new")
    public String newTransactionForm(Model model) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDate.now());

        model.addAttribute("transaction", transaction);
        model.addAttribute("types", TransactionType.values());

        return "transaction-form";
    }

    @PostMapping("/transactions/save")
    public String saveTransaction(
            @Valid @ModelAttribute("transaction") Transaction transaction,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("types", TransactionType.values());
            return "transaction-form";
        }

        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}