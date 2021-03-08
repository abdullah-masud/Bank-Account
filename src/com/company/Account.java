package com.company;

public class Account {
    public int balance;
    public String name;
    public int accountNumber;
    public static int initializeAccount = 0;

    public Account(int taka)
    {
        accountNumber = initializeAccount;
        balance = taka;
        initializeAccount++;
    }

    public int showBalance()
    {
        return balance;
    }

    public void deposit(int taka)
    {
        balance = balance + taka;
    }

    public void withdraw(int taka)
    {
        balance = balance - taka;
    }
}
