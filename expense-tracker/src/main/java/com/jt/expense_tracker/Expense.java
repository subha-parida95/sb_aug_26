package com.jt.expense_tracker;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    private int id;
    private String titile;
    private String category;
    private double price;
    private LocalDate date;

    // public Expense(int id, String titile, String category, double price, LocalDate date) {
    //     this.id = id;
    //     this.titile = titile;
    //     this.category = category;
    //     this.price = price;
    //     this.date = date;
    // }



    // public Expense(){

    // }

    

    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitile() {
    //     return titile;
    // }
    // public void setTitile(String titile) {
    //     this.titile = titile;
    // }
    // public String getCategory() {
    //     return category;
    // }
    // public void setCategory(String category) {
    //     this.category = category;
    // }
    // public double getPrice() {
    //     return price;
    // }
    // public void setPrice(double price) {
    //     this.price = price;
    // }
    // public LocalDate getDate() {
    //     return date;
    // }
    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }

    
}
