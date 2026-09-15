package com.jt.expense_tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
@RequestMapping ("/expenses")
public class ExepnseController {
    private final ExpenseService expenseService;
    
    @GetMapping
    public List<Expense> getExpenses(){
        
        return expenseService.getExpenses();
    }
    
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable int id){

        return expenseService.getExpenseById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense){ // RequestBody anotation is uses to convert jason data to java object
        return expenseService.addExpense(expense);
    }    

   @DeleteMapping("/{id}") // Line number 76 and 77 meaning same
   @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable int id){
        getExpenseById(id);
        expenseService.deleteExpenseById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Expense updateExpense(@RequestBody Expense expense){
        
        getExpenseById(expense.getId());
        return expenseService.updatExpense(expense);
    }
}
