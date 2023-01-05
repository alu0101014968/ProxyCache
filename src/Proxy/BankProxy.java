package Proxy;

import Interfaz.Bank;
import Service.RealBank;

import java.util.HashMap;
import java.util.Map;

// Clase proxy para el objeto real
public class BankProxy implements Bank {
    private RealBank realBank;
    private Map<String, Double> cache;

    public BankProxy() {
        cache = new HashMap<>();
    }

    public void insertAccount(String id, double amount) {
        if (realBank == null) {
            realBank = new RealBank();
        }
        realBank.insertAccount(id, amount);
    }

    @Override
    public void withdraw(String account, double amount) {
        if (realBank == null) {
            realBank = new RealBank();
        }
        realBank.withdraw(account, amount);
    }

    @Override
    public void deposit(String account, double amount) {
        if (realBank == null) {
            realBank = new RealBank();
        }
        realBank.deposit(account, amount);
    }

    @Override
    public double getBalance(String account) {
        if (cache.containsKey(account)) {
            return cache.get(account);
        } else {
            if (realBank == null) {
                realBank = new RealBank();
            }
            double balance = realBank.getBalance(account);
            cache.put(account, balance);
            return balance;
        }
    }
}
