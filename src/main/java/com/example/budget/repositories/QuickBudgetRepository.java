package com.example.budget.repositories;

import com.example.budget.models.QuickBudget;
import org.springframework.data.repository.CrudRepository;

public interface QuickBudgetRepository extends CrudRepository<QuickBudget, Long> {

}