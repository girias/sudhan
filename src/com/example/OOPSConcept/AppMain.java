package com.example.OOPSConcept;

import java.util.Scanner;

public class AppMain {

    Role[] roles = new Role[4];
    Privilege[] privileges = new Privilege[5];

    AppMain() {
        super();

        roles[0] = new Role(1, "Software Developer", "Software Developer");
        roles[1] = new Role(2, "Manager", "Manager");
        roles[2] = new Role(3, "Tester", "Tester");
        roles[3] = new Role(4, "General Manager", "General Manager");

        privileges[0] = new Privilege(1, "Admin");
        privileges[1] = new Privilege(2, "Decision Making");
        privileges[2] = new Privilege(3, "Ordering");
        privileges[3] = new Privilege(4, "Managing");
        privileges[3] = new Privilege(4, "Development");

    }

    public static void main(String[] args) {

        System.out.println("Enter the number of privileges to assign the role :");
        Scanner scanner = new Scanner(System.in);

        PrivilegeRole[] privilegeRoles = new PrivilegeRole[scanner.nextInt()];

        for (int i = 0, j = 1; i < privilegeRoles.length; i++, j++) {
            System.out.println("Enter the role id and privilege id " + j + " :");
            String[] input = scanner.nextLine().split(",");
            Role role = new Role(Integer.parseInt(input[0]), "", "");
//            privilegeRoles[i]();
        }


    }
}
