package com.example.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int accountNumber;
    private double balance;

    public Customer(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public Customer(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", acoountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
