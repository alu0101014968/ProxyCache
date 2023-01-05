import Interfaz.Bank;
import Proxy.BankProxy;


public class Main {
    public static void main(String[] args) {
        Bank bank = new BankProxy();

        // Consulta el saldo de la cuenta "12345"
        double balance = bank.getBalance("12345");
        System.out.println("Account Balance 12345: " + balance);

        // Realiza un depósito de 500 en la cuenta "12345"
        bank.deposit("12345", 500);
        balance = bank.getBalance("12345");
        System.out.println("Account Balance 12345: " + balance);

        // Realiza una retirada de 1000 de la cuenta "12345"
        bank.withdraw("12345", 1000);
        balance = bank.getBalance("12345");
        System.out.println("Account Balance 12345: " + balance);

        // Consulta el saldo de la cuenta "23456"
        balance = bank.getBalance("23456");
        System.out.println("Account Balance 23456: " + balance);
    }
}

/*
En este ejemplo, la clase RealBank es el objeto real que representa un banco, mientras que la clase BankProxy es el
proxy que proporciona acceso a los servicios del banco.

La clase Client es el cliente que utiliza el proxy para acceder a los servicios del banco.

Cuando se llama al método getBalance() de la clase BankProxy, el proxy verifica si ya ha consultado el saldo de la
cuenta en cuestión y lo tiene en caché. Si es así, devuelve el saldo almacenado en caché. Si no es así, llama al método
getBalance() del objeto real y almacena el resultado en caché para futuras consultas.

De esta manera, se reduce el tiempo de acceso a los servicios del banco y se mejora el rendimiento.
* */
