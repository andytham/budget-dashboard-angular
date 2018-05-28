package com.example.budget.controllers;

import com.example.budget.models.Budget;
import com.example.budget.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BudgetsController {

    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/budgets")
    public Iterable<Budget> findAllBudgets() {
        return budgetRepository.findAll();
    }

    @GetMapping("/budgets/{budgetId}")
    public Optional<Budget> findBudgetById(@PathVariable Long budgetId) {
        return budgetRepository.findById(budgetId);
    }

    @DeleteMapping("/budgets/{budgetId}")
    public HttpStatus deleteBudgetById(@PathVariable Long budgetId) {
        budgetRepository.deleteById(budgetId);
        return HttpStatus.OK;
    }

    @PostMapping("/budgets")
    public Budget createNewBudget(@RequestBody Budget newBudget) {
        return budgetRepository.save(newBudget);
    }

    @PatchMapping("/budgets/{budgetId}")
    public Budget updateBudgetById(@PathVariable Long budgetId, @RequestBody Budget budgetRequest) {

        Budget budgetFromDb = budgetRepository.findById(budgetId).get();

        budgetFromDb.setEvent(budgetRequest.getEvent());
        budgetFromDb.setFunds(budgetRequest.getFunds());
        budgetFromDb.setDate(budgetRequest.getDate());

        return budgetRepository.save(budgetFromDb);
    }

}