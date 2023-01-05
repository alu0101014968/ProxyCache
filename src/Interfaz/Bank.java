package Interfaz;

// Interfaz del objeto real
public interface Bank {
    public void insertAccount(String id, double amount);
    public void withdraw(String account, double amount);
    public void deposit(String account, double amount);
    public double getBalance(String account);
}
