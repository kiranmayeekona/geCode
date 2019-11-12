package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);

    private Map<String, Account> accountMap = new HashMap<>();
    ;

    public Bank() {
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        getAccount(accountNumber).withdraw(amount);
    }

    public int numAccounts() {
        return accountMap.size();
    }

    public double currentHoldingsSum() {
        return accountMap.entrySet().stream().mapToDouble(i -> i.getValue().getBalance()).sum();
    }

    public String nextMonthProfitOrLoss() {
        float sum= (float)accountMap.entrySet().stream().mapToDouble(i->i.getValue().getBalance()).sum();
        float nextMonthsum=(float) accountMap.entrySet().stream().mapToDouble(i->i.getValue().valueNextMonth()).sum();
        if(nextMonthsum<sum){
            return "bank has a total profit of "+(sum-nextMonthsum);
        }
        return "bank has a total loss of "+(nextMonthsum-sum);
    }
}
