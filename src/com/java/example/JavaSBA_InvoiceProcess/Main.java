package com.java.example.JavaSBA_InvoiceProcess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        User user;
        UserBO userBO;
        String status;
        Boolean logout;
        Invoice invoice;
        Integer statusId;
        Integer invoiceId;
        String newLine = "\n";
        String invoiceDetails;
        List<Invoice> invoiceList;
        StringBuilder mainMenu = new StringBuilder();
        StringBuilder userMenu = new StringBuilder();
        StringBuilder auditorMenu = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mainMenu.append("1. Login").append(newLine)
                .append("2. Exit").append(newLine)
                .append("Enter the choice:");
        userMenu.append("1. Create invoice").append(newLine)
                .append("2. Update invoice").append(newLine)
                .append("3. Invoice Payment").append(newLine)
                .append("4. Logout").append(newLine)
                .append("Enter the choice:");
        auditorMenu.append("1. Approved").append(newLine)
                .append("2. Deny");
        List<String> auditorList = new ArrayList<String>() {
            {
                add("Approved");
                add("Deny");
            }
        };
        while (true) {
            System.out.println(mainMenu.toString());
            int choice = new Integer(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter the username:");
                    String userName = br.readLine();
                    System.out.println("Enter the password:");
                    String password = br.readLine();

                    if (/*fill the code*/true) {
                        logout = false;

                        while (true) {
                            System.out.println(userMenu.toString());
                            int userChoice = new Integer(br.readLine());
                            switch (userChoice) {
                                case 1:
                                    try {
                                        System.out.println("Enter the invoice detail:");
                                        invoiceDetails = br.readLine();

                                        // fill the code
                                    } catch (Exception e) {
                                        System.out.println(e.toString());
                                    }
                                    break;
                                case 2:
                                    try {
                                        //fill the code

                                        if (!invoiceList.isEmpty()) {
                                            System.out.format("%-5s %-15s %-10s %-15s %-15s %s\n", "Id",
                                                    "Invoice number", "Amount",
                                                    "Status", "Created by",
                                                    "Created on");
                                            //fill the code here

                                            System.out.println("Enter the id to update the status:");
                                            invoiceId = new Integer(br.readLine());
                                            if (/* fill the code*/) {
                                                System.out.println(auditorMenu.toString());
                                                System.out.println("Enter the status number:");
                                                statusId = new Integer(br.readLine());

                                            } else {
                                                System.out.println("Invoice Id is invalid");
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.toString());
                                    }
                                    break;
                                case 3:
                                    try {
                                        // fill the code here
                                        if (/* fill the code*/) {
                                            System.out.format("%-5s %-15s %-10s %-15s %-15s %s\n", "Id",
                                                    "Invoice number", "Amount",
                                                    "Status", "Created by",
                                                    "Created on");
                                            //fill the code here

                                            System.out.println("Enter the id to Pay::");
                                            invoiceId = new Integer(br.readLine());
                                            if (/* fill the code*/) {
                                                // fill teh code here

                                            } else {
                                                System.out.println("Invoice Id is invalid");
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.toString());
                                    }
                                    break;
                                case 4:
                                    logout = true;
                                    break;
                            }
                            if (logout)
                                break;
                        }
                    } else
                        System.out.println("Invalid username or password");
                    break;
                case 2:
                    System.exit(0);
            }

        }

    }

    public static UserBO findRole(User user) {
        String role = user.getRole();
        UserBO userBo = null;
        if (role.equalsIgnoreCase("clerk")) {
            userBo = new ClerkBO();

        }
        if (role.equalsIgnoreCase("payment releaser")) {
            userBo = new PaymentReleaserBO();
        }
        if (role.equalsIgnoreCase("auditor")) {
            userBo = new AuditorBO();
        }
        return userBo;
    }

}