package com.example.budget.controllers;

import com.example.budget.models.QuickBudget;
import com.example.budget.repositories.QuickBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class QuickBudgetsController {

    @Autowired
    private QuickBudgetRepository quickBudgetRepository;

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("/quick")
    public Iterable<QuickBudget> findAllQuickBudgets() {
        return quickBudgetRepository.findAll();
    }

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("/quick/{quickBudgetId}")
    public Optional<QuickBudget> findQuickBudgetById(@PathVariable Long quickBudgetId) {
        return quickBudgetRepository.findById(quickBudgetId);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @DeleteMapping("/quick/{quickBudgetId}")
    public HttpStatus deleteQuickBudgetById(@PathVariable Long quickBudgetId) {
        quickBudgetRepository.deleteById(quickBudgetId);
        return HttpStatus.OK;
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/quick")
    public QuickBudget createNewQuickBudget(@RequestBody QuickBudget newQuickBudget) {
        return quickBudgetRepository.save(newQuickBudget);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping("/quick/{quickBudgetId}")
    public QuickBudget updateQuickBudgetById(@PathVariable Long quickBudgetId, @RequestBody QuickBudget quickBudgetRequest) {

        QuickBudget quickBudgetFromDb = quickBudgetRepository.findById(quickBudgetId).get();

        quickBudgetFromDb.setName(quickBudgetRequest.getName());
        quickBudgetFromDb.setFunds(quickBudgetRequest.getFunds());

        return quickBudgetRepository.save(quickBudgetFromDb);
    }

}