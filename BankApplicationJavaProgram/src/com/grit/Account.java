package com.grit;

public class Account{
    //variabler för att hålla saldo, kontotyp, konto och summa vid transaktion.
    double balance;
    int accountid;
    static int accountcounter=1001;
    double amount;

    //konstruktor
    public Account(){
        this.accountid=getAccountId();
        this.balance= 0;
    }
    //Beskrivning: (getmetod för att hämta saldo)
    public double getBalance(){
        return balance;
    }
    //Beskrivning: (getmetod för att hämta kontotyp)
    public int getAccountId(){
        accountid=accountcounter;
        accountcounter++;
        return accountid;
    }

    //Beskrivning: (getmetod för att hämta konto)
    public String getAccount(){
        return "Kontoid: "+accountid+" Saldo: "+balance;

    }
    //Beskrivning: Metod för att göra om objektet till en sträng som returnerar kundinformation
    @Override
    public String toString(){
        return "Kontotyp:"+getAccount()+"";
    }

}