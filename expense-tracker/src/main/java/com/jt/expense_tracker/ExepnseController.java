package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class ExepnseController {
    private final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABLE = "expenses";
    
    // public ExepnseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    // @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    @GetMapping("/expenses")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public List<Expense> getExpenses(){
        // String sql = "SELECT * FROM expenses";
        String sql = "SELECT * FROM %s".formatted(EXPENSES_TABLE);

        // List<Expense> expenses = new ArrayList<>();

        // jdbcTemplate.query(sql, (resultSet) ->{
        //     System.out.println("id is: " + resultSet.getInt("id"));
        //     System.out.println("title is: " + resultSet.getString("title"));
        //     System.out.println("category is: " + resultSet.getString("category"));

        //     // Expense expense = new Expense();
        //     // expense.setId(resultSet.getInt("id"));

        //     var id  = resultSet.getInt("id");
        //     var titile = resultSet.getString("title");
        //     var category = resultSet.getString("category");
        //     var price = resultSet.getDouble("price");
        //     var date = resultSet.getDate("date").toLocalDate();

        //     var expense = new Expense(id, titile, category, price, date);
        //     expenses.add(expense);
        // });

        // List<Expense> expenses = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        // return expenses;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
    }

     // {id} is the pathvariable here we pass anything at the time of executioon in browser that store directly in id
    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.GET)
    // @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id){
        System.out.println("Id is " + id);
        var sql = "SELECT * FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
        Expense expense = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Expense.class), id);
        return expense;
    }

    // @RequestMapping(value = "/expenses", method = RequestMethod.POST)
    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense){ // RequestBody anotation is uses to convert jason data to java object
        var sql = "INSERT INTO %s (title, category, price, date) values(?,?,?,?)".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(), expense.getDate());
        return expense;
    }    

    // @RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/expenses/{id}") // Line number 76 and 77 meaning same
    public void deleteExpense(@PathVariable int id){
        String sql = "DELETE FROM %s WHERE id =?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql, id);
    }

    @PutMapping("/expenses")
    public Expense updateExpense(@RequestBody Expense expense){
        var sql = "UPDATE %s SET title=?, category=?, price=?, date=? WHERE id=?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(), expense.getDate(), expense.getId());
        // Expense updateExpense = getExpenseById(expense.getId());
        // return updateExpense;

        return getExpenseById(expense.getId());
    }
}
