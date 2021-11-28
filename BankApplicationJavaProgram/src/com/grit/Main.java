package com.grit;

public class Main
{
    private final Bank bank = new Bank();

    // Kör applikation

    public void test()
    {
        System.out.println("Välkommen till ReggieBanken\n");


        // Skapar kunder...
        bank.addCustomer("Redon Shaqiri", 8202267620L, true );
        bank.addCustomer("Hampus Lindén", 7505121231L, true );
        bank.addCustomer("Dante Karl", 8809121212L, true );

        // Skriver ut en lista med kunder
        printBank();

        // Byt namn på kund
        bank.changeName("Sean Paul", 8202267620L, true);

        // Skapa konton
        bank.addAccount(8202267620L);	// 1001
        bank.addAccount(7505121231L); // 1002
        bank.addAccount(8809121212L); // 1003

        // SKriver ut kunderna inklusive konton, pnr 7712.. ska vara ogiltig och Dante Karl ska ha bytt namn till Sean Paul.
        printCustomer(8202267620L);
        printCustomer(7505121231L);
        printCustomer(7712258876L);
        printCustomer(8809121212L);

        // Sätter in 1000 kr på konto 1002 (ska inte fungera pga fel account id)
        Bank.deposit(8202267620L, 1002, 1000, true);

        // Sätter in 10000 kr på konto 1001
        Bank.deposit(8202267620L, 1001, 10000, true);

        // Ta ut 5000 kr på konto 1001
        bank.withdraw(8202267620L, 1001, 5000, true);

        // Ta ut 1 kr på konto 1002 (ska inte fungera eftersom att vi har 0kr på kontot)
        bank.withdraw(7505121231L, 1002, 1, true);


        // Resultat från deposit och withdraw metoden.
        printCustomer(8202267620L);
        printCustomer(7505121231L);

        // Tar bort kund
        bank.removeCustomer(8202267620L);

        // Resultat på att Joe Rogan inte längre finns kvar hos oss på banken.
        printCustomer(8202267620L);

        // Printa resultat på kunder efter metoder som använts.
        printBank();
    }


    // Metod för att skriva ut kundlistan

    private void printBank()
    {
        System.out.println("\n ReggieBanken");
        System.out.println(bank.infoBank());
    }

    //Metod för att skriva ut en kund

    private void printCustomer(long pNr)
    {
        System.out.println("\n UTSKRIFT AV KUND\t " + pNr);
        System.out.println(bank.infoCustomer(pNr));
    }

    // Skapar en instans av BankMain-klassen och kör igång menyn

    public static void main(String[] args)
    {

        Main main = new Main();
        main.test();
    }
}