package Service;

import Interfaz.Bank;

import java.util.HashMap;
import java.util.Map;

// Implementación del objeto real
public class RealBank implements Bank {
    private Map<String, Double> accounts;

    public RealBank() {
        accounts = new HashMap<>();
    }

    @Override
    public void insertAccount(String id, double amount) {
        accounts.put(id, amount);
    }

    @Override
    public void withdraw(String account, double amount) {
        if (accounts.containsKey(account)) {
            double balance = accounts.get(account);
            if (balance >= amount) {
                accounts.put(account, balance - amount);
                System.out.println("Withdrawal completed successfully");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Nonexistent account");
        }
    }

    @Override
    public void deposit(String account, double amount) {
        if (accounts.containsKey(account)) {
            double balance = accounts.get(account);
            accounts.put(account, balance + amount);
            System.out.println("Deposit made successfully");
        } else {
            System.out.println("Nonexistent account");
        }
    }

    @Override
    public double getBalance(String account) {
        return accounts.getOrDefault(account, 0.0);
    }

    public Map<String, Double> getAccounts() {
        return accounts;
    }
}

