package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Account accounts[] = new Account[100];
	    for(int i=0; i<5; i++)
        {
            accounts[i] = new Account(500+i);
        }

        System.out.println("0: Exit");
        System.out.println("1: Show Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Transfer");

        Scanner scanner = new Scanner(System.in);
        int choice;

        while(scanner.hasNext())
        {
            choice = scanner.nextInt();
            if (choice==0)
            {
                System.out.println("Exiting...");
                break;
            }

            int accN, taka, recipientAccN;

            switch (choice)
            {
                // SHOW BALANCE
                case 1:
                    System.out.print("Enter Account Number: ");
                    accN = scanner.nextInt();
                    for(int i=0; i<5; i++)
                    {
                        if(accN==accounts[i].accountNumber)
                        {
                            System.out.print("\n");
                            System.out.println("Balance: "+accounts[i].showBalance());
                            break;
                        }
                    }
                    break;

                // DEPOSIT
                case 2:
                    System.out.print("Enter Account Number: ");
                    accN = scanner.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    taka = scanner.nextInt();
                    for(int i=0; i<5; i++)
                    {
                        if(accN==accounts[i].accountNumber)
                        {
                            accounts[i].deposit(taka);
                            break;
                        }
                    }
                    break;

                // WITHDRAWAL
                case 3:
                    System.out.print("Enter Account Number: ");
                    accN = scanner.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    taka = scanner.nextInt();
                    for(int i=0; i<5; i++)
                    {
                        if(accN==accounts[i].accountNumber)
                        {
                            if(taka>accounts[i].balance)
                            {
                                System.out.print("\n");
                                System.out.println("you don't have sufficient balance to complete this withdrawal");
                            }
                            else
                            {
                                accounts[i].withdraw(taka);
                                break;
                            }
                        }
                    }
                    break;

                // TRANSFER
                case 4:
                    System.out.print("Enter Account Number: ");
                    accN = scanner.nextInt();
                    System.out.print("Enter Recipient Account Number: ");
                    recipientAccN = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    taka = scanner.nextInt();
                    for(int i=0; i<5; i++)
                    {
                        if(accN==accounts[i].accountNumber)
                        {
                            if(taka>accounts[i].balance)
                            {
                                System.out.print("\n");
                                System.out.println("you don't have sufficient balance to complete this transaction");
                            }
                            else
                            {
                                accounts[i].withdraw(taka);
                            }
                        }
                    }
                    for(int i=0; i<5; i++)
                    {
                        if(recipientAccN==accounts[i].accountNumber)
                        {
                            if(taka>accounts[i].balance)
                            {
                                break;
                            }
                            else
                            {
                                accounts[i].deposit(taka);
                            }
                        }
                    }
                    break;
            }
            System.out.print("\n");
            System.out.println("0: Exit");
            System.out.println("1: Show Balance");
            System.out.println("2: Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4: Transfer");
        }
    }
}
