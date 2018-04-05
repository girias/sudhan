package com.java.example.oops1;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Account accountArray[] = new Account[5];
        accountArray[0] = new Account("vicky", "vicky123", 999, "0011".getBytes());
        accountArray[1] = new Account("mark", "mark007", 100, "1111".getBytes());
        accountArray[2] = new Account("priya", "priya332", 444, "0101".getBytes());
        accountArray[3] = new Account("max", "max232", 555, "0001".getBytes());
        accountArray[4] = new Account("martin", "martin345", 888, "0010".getBytes());
        System.out.println("Enter the login mode");
        System.out.println("1)Browser\n2)Wallet\n3)Mobile");
        //fill the code

        Account account = new Account();
        boolean authSuccess = false;
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Enter the username");
                //fill the code
                account.setUsername(scanner.nextLine());
                System.out.println("Enter the password");
                //fill the code
                account.setPassword(scanner.nextLine());

                for (Account acc : accountArray) {
                    if (account.authentication(acc.getUsername(), acc.getPassword())) {
                        authSuccess = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter the username");
                //fill the code
                account.setUsername(scanner.nextLine());
                System.out.println("Enter the CVV");
                //fill the code
                account.setCvv(Integer.parseInt(scanner.nextLine()));

                for (Account acc : accountArray) {
                    if (account.authentication(acc.getUsername(), acc.getCvv())) {
                        authSuccess = true;
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Enter the fingerprint");
                //fill the code
                account.setFingerPrint(scanner.nextLine().getBytes());

                for (Account acc : accountArray) {
                    if (account.authentication(acc.getFingerPrint())) {
                        authSuccess = true;
                        break;
                    }
                }
                break;
        }
        if (!authSuccess) {
            System.out.println("Authentication failed");
        } else {
            System.out.println("Authentication successful");
        }
    }
}
