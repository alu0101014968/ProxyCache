package Service;

import Interfaz.Bank;

import java.util.HashMap;
import java.util.Map;

// Implementación del objeto real
public class RealBank implements Bank {
    private Map<String, Double> accounts;

    public RealBank() {
        accounts = new HashMap<>();
        accounts.put("12345", 1000.0);
        accounts.put("23456", 2000.0);
        accounts.put("34567", 3000.0);
    }

    @Override
    public void withdraw(String account, double amount) {
        if (accounts.containsKey(account)) {
            double balance = accounts.get(account);
            if (balance >= amount) {
                accounts.put(account, balance - amount);
                System.out.println("Retirada realizada con éxito");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Cuenta inexistente");
        }
    }

    @Override
    public void deposit(String account, double amount) {
        if (accounts.containsKey(account)) {
            double balance = accounts.get(account);
            accounts.put(account, balance + amount);
            System.out.println("Depósito realizado con éxito");
        } else {
            System.out.println("Cuenta inexistente");
        }
    }

    @Override
    public double getBalance(String account) {
        if (accounts.containsKey(account)) {
            return accounts.get(account);
        } else {
            return 0.0;
        }
    }
}

