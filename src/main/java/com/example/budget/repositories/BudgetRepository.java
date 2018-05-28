package com.example.budget.repositories;

import com.example.budget.models.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BudgetRepository extends CrudRepository<Budget, Long> {

}