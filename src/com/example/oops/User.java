package com.example.oops;

import java.io.BufferedReader;

public class User {
    private String name;
    private String userName;
    private String password;
    private String role;

    public User(String name, String userName, String password, String role) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void display(BufferedReader br, Requirement[] requirement, User[] user) throws Exception {
        int size = 0, i, choice;

        System.out.println(requirement.length);

        for (i = 0; i < requirement.length; i++) {
            if (requirement[i] != null)
                size++;
        }
        System.out.println(size);

        if (role.equals("SM")) {

            while (true) {
                System.out.println("1. Create BackLog\n2. Count Requirements\n3. Assign Requirements\n4. Logout\nEnter your choice :");
                choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        //fill code here.
                        System.out.println("Enter the number of requirement to create :");
                        User tempUser = null;
                        for (User u : user) {
                            if (u.role.equalsIgnoreCase("SM")) {
                                tempUser = u;
                            }
                        }

                        int numberOfRequirements = Integer.parseInt(br.readLine());

                        for (int k = 1; k <= numberOfRequirements; k++) {
                            System.out.println("Enter the id and description " + k + ":");
                            String[] require = br.readLine().split(",");
                            requirement[k - 1] = new Requirement(Integer.parseInt(require[0]), require[1], tempUser, null, 0, 0f, true);

                        }
                        System.out.println("Requirement created successfully");
                        break;
                    case 2:
                        //fill code here.
                        size = 0;
                        for (int counter = 0; counter < requirement.length; counter++) {
                            if (requirement[counter] != null)
                                size++;
                        }
                        System.out.println("The total number of requirement is :" + size);
                        break;
                    case 3:
                        //fill code here
                        for (i = 0; i < size; i++) {
                            System.out.format("%-15s %s\n", requirement[i].getId(), requirement[i].getDescription());
                        }
                        System.out.println("Enter the requirement id and user name :");
                        String[] reqIdName = br.readLine().split(",");

                        for (int k = 0; k < size; k++) {
                            if (requirement[k].getId().equals(Integer.parseInt(reqIdName[0]))) {
                                //Get the user from user array and map to requirement
                                for (User u : user) {
                                    if (u.getUserName().equalsIgnoreCase(reqIdName[1])) {
                                        requirement[k].setAssignedTo(u);
                                    }
                                }

                                System.out.println("Assigned successfully");
                            }
                        }

                        break;
                    default:
                        break;
                }

                if (choice == 4)
                    break;
            }
        } else if (role.equals("TM")) {
            while (true) {
                System.out.println("1. Display requirement list\n2. Logout\nEnter your choice :");
                int teamMemberChoice = Integer.parseInt(br.readLine());
                //fill code here.
                switch (teamMemberChoice) {
                    case 1:
                        if (size > 0) {
                            System.out.format("%-15s. %s\n", "Id", "Description");
                            for (i = 0; i < size; i++) {
                                if (requirement[i].getAssignedTo() != null && requirement[i].getAssignedTo().getRole().equalsIgnoreCase("TM")) {
                                    System.out.format("%-15s. %s\n", requirement[i].getId(), requirement[i].getDescription());
                                }
                            }
                        } else {
                            System.out.println("No records found");
                        }

                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
                if (teamMemberChoice == 2)
                    break;

            }
        } else if (role.equals("PO")) {
            while (true) {
                System.out.println("1. List requirements\n2. Allocate budget\n3. Allocate plan time\n4. Logout\nEnter your choice :");
                int productOwnerChoice = Integer.parseInt(br.readLine());
                size = 0;
                for (i = 0; i < requirement.length; i++) {
                    if (requirement[i] != null)
                        size++;
                }

                if (productOwnerChoice == 1) {
                    if (size == 0)
                        System.out.println("No record found");
                    else {
                        System.out.format("%-15s %-15s %-15s %s\n", "Id", "Description", "Budget", "Time");
                        //fill code here.
                        for (i = 0; i < size; i++) {
                            System.out.format("%-15s %-15s %-15s %s\n", requirement[i].getId(), requirement[i].getDescription(), requirement[i].getBudget(), requirement[i].getPlanTime());
                        }
                    }
                } else if (productOwnerChoice == 2) {
                    System.out.println("Enter the id and budget :");
                    String[] budgetDetail = br.readLine().split(",");
                    //fill code here.

                    for (int k = 0; k < size; k++) {
                        if (requirement[k].getId().equals(Integer.parseInt(budgetDetail[0]))) {
                            requirement[k].setBudget(Float.parseFloat(budgetDetail[1]));
                            System.out.println("Budget assigned successfully");
                        }
                    }

                } else if (productOwnerChoice == 3) {
                    System.out.println("Enter the id and plan time :");
                    String[] planTimeDetail = br.readLine().split(",");
                    //fill code here.

                    for (int k = 0; k < size; k++) {
                        if (requirement[k].getId().equals(Integer.parseInt(planTimeDetail[0]))) {
                            requirement[k].setPlanTime(Integer.parseInt(planTimeDetail[1]));
                            System.out.println("Time assigned successfully");
                        }
                    }
                } else if (productOwnerChoice == 4)
                    break;

            }
        }

    }
}
