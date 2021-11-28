package com.grit;

import java.util.ArrayList;

//public class Bank extends Account{
public class Bank {

    //Arraylistan som ska innehålla kunder
    private static ArrayList <Customer>customers;

    //konstruktor, instansierar arraylistan
    public Bank() {
        super();
        customers = new ArrayList<>();
    }

//Beskrivning: Returnerar en sträng med alla bankens kunder

    public String infoBank() {
        StringBuilder info = new StringBuilder();
        for (Customer customer : customers) info.append(customer.getCustomer()).append("\n");
        return info.toString();
    }


    // Beskrivning: (Skapar ny kund med pNr och name)

    public boolean addCustomer(String name, long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr) return false;
        }
        customers.add(new Customer(name, pNr));
        return true;
    }

    // Beskrivning: (Returnerar sträng med presentation av vald kund(pNr+namn och eventuella konton))

    public String infoCustomer(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                String info = customer.getCustomer();
                for (Account account : customer.accounts) {
                    info += account.getAccount() + "\n";
                }
                return info;
            }
        }
        return "Ingen kund med det personnummret.";
    }

    // Beskrivning: Tar bort kund och dess konto, returnerar information om vad som har tagits bort.

    public String removeCustomer(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                String info = customer.getCustomer();
                customers.remove(customer);
                int total = 0;
                for (Account account : customer.accounts) {
                    info += account.getAccount() + "\n";
                    total += account.balance;
                }
                return "Kund borttagen: " + info + "\n Saldo total: " + total;
            }
        }
        return null;

    }

    // Beskrivning: (Skapar ett konto till kund med personnummer, returnerar true om det går annars false)
    public void addAccount(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                Account newaccount = new Account();
                customer.accounts.add(newaccount);
                System.out.println("\t- True!");
                return;
            }
        }
        System.out.println("\t- False!");
    }

    // Skapar en kund samt skriver samt meddelar om testet blev godkänt

    void addCustomer(String name, long pNr, boolean check)
    {
        System.out.println(" SKAPA KUND\t" + pNr + "\t" + name);
        if(addCustomer(name, pNr) == check)
            System.out.println("\t- True!");
        else
            System.out.println("\t- False!");
    }
    // Beskrivning: (Byter namn på kund med rätt personnummer pNr till nytt name)

    public boolean changeCustomerName(String name, long pNr) {
        for (Customer customer : customers)
            //ifsats för att kolla om customers pnr är lika som det sökta
            if (customer.getpNr() == pNr) {
                customer.setName(name);
                return true;
            }
        return false;
    }

    // Byter namn på en kund samt meddelar om det blir godkänt.

    void changeName(String name, long pNr, boolean check)
    {
        System.out.println(" ÄNDRA NAMN\t" + pNr + "\t" + name);
        if(changeCustomerName(name, pNr) == check)
            System.out.println("\t- True!");
        else
            System.out.println("\t- Unable to change name");
    }

//Beskrivning: Gör en insättning på konto med kontonnummer accountId som tillhör kundens personnummer.

    public static boolean deposit(long pNr, int accountId, double amount) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        account.balance += amount;
                        return true;
                    }
                }
            }
        }
        return false;
    }

//Beskrivning: (Gör ett uttag på konto med kontonnummer accountId som tillhör kunden pnr)

    public boolean withdraw(long pNr, int accountId, int amount) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        if (account.balance >= amount) {
                            account.balance -= amount;
                            return true;
                        } else return false;
                    }
                }
            }
        }
        return false;
    }

// Beskrivning: (Stänger ett konto med kontonnummer accountId som tillhör kunden pNr,

    public String closeAccount(long pNr, int accountId) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        String info = account.getAccount();
                        customer.accounts.remove(account);
                        return "Kontot avslutat. " + info;
                    }
                }
            }
        }
        return "Kontot existerar inte.";
    }



    // Metod som sätter in pengar på konto samt skriver ut om testet blev godkänt

    static void deposit(long pNr, int accountId, int amount, boolean check)
    {
        System.out.println(" INSÄTTNING\t" + pNr + "\t" + accountId + "\t" + amount + " kr");
        if(deposit(pNr, accountId, amount) == check)
            System.out.println("\t- True!");
        else
            System.out.println("\t- False!");
    }

    // Metod som sätter in pengar på konto samt skriver ut om testet blev godkänt

    void withdraw(long pNr, int accountId, int amount, boolean check)
    {
        System.out.println(" UTTAG\t" + pNr + "\t" + accountId + "\t-" + amount + " kr");
        if(withdraw(pNr, accountId, amount) == check)
            System.out.println("\t- True!");
        else
            System.out.println("\t- False!");
    }
}
