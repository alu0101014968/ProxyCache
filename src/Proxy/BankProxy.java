package Proxy;

import Interfaz.Bank;
import Service.RealBank;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Clase proxy para el objeto real
public class BankProxy implements Bank {
    private RealBank realBank;
    private Map<String, Double> cache;
    private final static String COLOR = "\u001B[31m";

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
        getDate();
        System.out.println("   INFO:  ----BankProxy - Get Money----  Getting " + amount + "\u001B[0m");
        realBank.withdraw(account, amount);
        cache.put(account, realBank.getAccounts().get(account));
    }

    @Override
    public void deposit(String account, double amount) {
        if (realBank == null) {
            realBank = new RealBank();
        }
        getDate();
        System.out.println("   INFO:  ----BankProxy - Deposit Money----  Depositing " + amount + "\u001B[0m");
        realBank.deposit(account, amount);
        cache.put(account, realBank.getAccounts().get(account));
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

    private void getDate() {
        Date date = new Date();
        System.out.print(COLOR + date);
    }
}
