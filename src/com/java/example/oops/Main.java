package com.java.example.oops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, i, choice;
        String userDetail;
        System.out.println("Enter number of user :");
        n = Integer.parseInt(br.readLine());
        User user[] = new User[n];

        Requirement[] requirement = new Requirement[20];
        for (i = 0; i < n; i++) {
            System.out.println("Enter user " + (i + 1) + " detail :");
            userDetail = br.readLine();
            //fill code here.
            String[] inputUser = userDetail.split(",");
            for (String str : inputUser)
                user[i] = new User(inputUser[0], inputUser[1], inputUser[2], inputUser[3]);
        }
        while (true) {
            System.out.println("1. Login\n2. Exit\nEnter your choice :");
            choice = Integer.parseInt(br.readLine());
            if (choice == 2)
                System.exit(0);
            System.out.println("Enter the user name :");
            String userName = br.readLine();
            System.out.println("Enter the password :");
            String password = br.readLine();
            for (User u : user) {
                if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                    u.display(br, requirement, user, u);
                }
            }
        }
    }

}


