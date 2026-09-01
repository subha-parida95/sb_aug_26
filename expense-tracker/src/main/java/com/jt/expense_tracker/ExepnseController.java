package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExepnseController {
    private JdbcTemplate jdbcTemplate;
    
    // public ExepnseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public List<Expense> getExpenses(){
        String sql = "SELECT * FROM expenses";

        // List<Expense> expenses = new ArrayList<>();

        // jdbcTemplate.query(sql, (resultSet) ->{
        //     // System.out.println("id is: " + resultSet.getInt("id"));
        //     // System.out.println("title is: " + resultSet.getString("title"));
        //     // System.out.println("category is: " + resultSet.getString("category"));

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
}
