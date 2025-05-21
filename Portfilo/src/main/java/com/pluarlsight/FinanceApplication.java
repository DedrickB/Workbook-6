package com.pluarlsight;

import com.pluarlsight.finance.BankAccount;
import com.pluarlsight.finance.Valuable;



import com.pluarlsight.finance.*;

public class FinanceApplication {

    public static void main(String[] args) {
        // Original test code for BankAccount
        BankAccount account1 = new BankAccount("Pam", "123", 12500.0);
        Valuable account2 = new BankAccount("Gary", "456", 1500.0); // Stays as Valuable for demonstration

        System.out.println("Initial state:");
        System.out.println("Account 1 (" + account1.getName() + ", #" + account1.getAccountNumber() + "): Balance = " + account1.getBalance());
        System.out.print("Account 2 (as Valuable): Value = " + account2.getValue());
        if (account2 instanceof BankAccount) {
            BankAccount garysBankAccount = (BankAccount) account2;
            System.out.println(" (Actual name: " + garysBankAccount.getName() + ", Account#: " + garysBankAccount.getAccountNumber() + ", Balance: " + garysBankAccount.getBalance() + ")");
        } else {
            System.out.println();
        }
        System.out.println();

        System.out.println("Attempting deposits...");
        account1.deposit(100);
        System.out.println("Deposited 100 into account1. New balance for " + account1.getName() + ": " + account1.getBalance());

        if (account2 instanceof BankAccount) {
            BankAccount tempAccount = (BankAccount) account2;
            tempAccount.deposit(100);
            System.out.println("Deposited 100 into account2 (after casting to BankAccount). New balance for " + tempAccount.getName() + ": " + tempAccount.getBalance());
        } else {
            System.out.println("Could not deposit into account2 as it is not a BankAccount or deposit method is not on Valuable.");
        }
        System.out.println();
        System.out.println("------------------------------------");

        // --- Portfolio Testing ---
        System.out.println("\n--- Portfolio Testing ---");
        Portfolio myPortfolio = new Portfolio("My Investment Portfolio", "John Doe");

        // Add assets to the portfolio
        myPortfolio.add(new BankAccount("Savings", "BA789", 5000.00));
        myPortfolio.add(new CreditCard("Visa Platinum", "CC123", 1200.00)); // $1200 debt
        myPortfolio.add(new House(2005, 2200, 4)); // 2200 sqft * $150/sqft = $330,000
        myPortfolio.add(new Gold(10)); // 10 units * $1000/unit = $10,000
        myPortfolio.add(new Jewelry("Diamond Necklace", 2.5)); // 2.5 * 100 = $250
        myPortfolio.add(account1); // Add Pam's account (value: 12500 + 100 = 12600)
        

        // Test getValue()
        System.out.printf("Total Portfolio Value: $%.2f\n", myPortfolio.getValue());

        // Test getMostValuable()
        Valuable mostValuable = myPortfolio.getMostValuable();
        if (mostValuable != null) {
            System.out.print("Most Valuable Asset: ");
            if (mostValuable instanceof FixedAsset) {
                System.out.print(((FixedAsset) mostValuable).getName());
            } else if (mostValuable instanceof BankAccount) {
                System.out.print("Bank Account " + ((BankAccount) mostValuable).getName());
            } else if (mostValuable instanceof CreditCard) {
                System.out.print("Credit Card " + ((CreditCard) mostValuable).getName());
            }
            System.out.printf(" with value $%.2f\n", mostValuable.getValue());
        }

        // Test getLeastValuable()
        Valuable leastValuable = myPortfolio.getLeastValuable();
        if (leastValuable != null) {
            System.out.print("Least Valuable Asset: ");
            if (leastValuable instanceof FixedAsset) {
                System.out.print(((FixedAsset) leastValuable).getName());
            } else if (leastValuable instanceof BankAccount) {
                System.out.print("Bank Account " + ((BankAccount) leastValuable).getName());
            } else if (leastValuable instanceof CreditCard) {
                System.out.print("Credit Card " + ((CreditCard) leastValuable).getName());
            }
            System.out.printf(" with value $%.2f\n", leastValuable.getValue());
        }
    }
}