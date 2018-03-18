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
                        int numberOfRequirements = Integer.parseInt(br.readLine());
                        requirement = new Requirement[numberOfRequirements];
//                        Requirement[] req = new Requirement[numberOfRequirements];
                        for (int k = 1; k <= numberOfRequirements; k++) {
                            System.out.println("Enter the id and description " + k + ":");
                            String[] require = br.readLine().split(",");

                            User tempUser = new User(user[0].getName(), user[0].getUserName(), user[0].getPassword(), user[0].getRole());
                            requirement[k - 1] = new Requirement(Integer.parseInt(require[0]), require[1], tempUser, tempUser, 0, 0f, true);

                        }
                        System.out.println("Requirement created successfully");
                        break;
                    case 2:
                        //fill code here.
                        System.out.println("The total number of requirement is :" + requirement.length);
                        break;
                    case 3:
                        //fill code here
                        for (Requirement temp : requirement) {
                            System.out.format("%-15s. %s\n", temp.getId(), temp.getDescription());
                        }
                        System.out.println("Enter the requirement id and user name :");
                        String[] reqIdName = br.readLine().split(",");
//                        System.out.println("reqIdName: " + reqIdName[0]);
//                        System.out.println("reqIdName: " + reqIdName[1]);
//                        System.out.println("user: " + user[0]);
//                        System.out.println("user: " + user[1]);
//                        System.out.println("user: " + user[2]);
                        for (int k = 0; k < requirement.length; k++) {
                            if (requirement[k].getId() == Integer.parseInt(reqIdName[0])) {
                                //Get the user from user array and map to requirement
                                for (User u : user) {
                                    if (u.getUserName().equalsIgnoreCase(reqIdName[1]))
                                        requirement[k].setAssignedTo(u);
                                }

                                System.out.println("Assigned successfully");
                            }
                        }
//                        for (Requirement temp : requirement) {
//                            if (temp.getId() == Integer.parseInt(reqIdName[0])) {
//                                //Get the user from user array and map to requirement
//                                for(User u : user){
//                                    if(u.getUserName().equalsIgnoreCase(reqIdName[1]))
//                                        temp.setAssignedTo(u);
//                                }
//
//                                System.out.println("Assigned successfully");
//                            }
//                        }
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
                        for (Requirement requirement1 : requirement) {
                            System.out.println(requirement1);
                        }
                        for (Requirement req : requirement) {
                            if (req.getAssignedTo().getRole().equalsIgnoreCase("TM"))
                                System.out.format("%-15s. %s\n", req.getId(), req.getDescription());

                        }
                        break;
                    case 2:
                        break;
                }

            }
        } else if (role.equals("PO")) {
            while (true) {
                System.out.println("1. List reqiurements\n2. Allocate budget\n3. Allocate plan time\n4. Logout\nEnter your choice :");
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
                    }
                } else if (productOwnerChoice == 2) {
                    System.out.println("Enter the id and budget :");
                    String budgetDetail = br.readLine();
                    //fill code here.
                } else if (productOwnerChoice == 3) {
                    System.out.println("Enter the id and plan time :");
                    String planTimeDetail = br.readLine();
                    //fill code here.
                } else if (productOwnerChoice == 4)
                    break;


            }
        }

    }
}
