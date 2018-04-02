package com.java.example.oops;

public class TeamMember extends User {

    public TeamMember(String name, String userName, String password, String role) {
        super(name, userName, password, role);
    }

    public void myRequriements(Requirement[] requirement, String userName) {
        int i;
        int size = 0;
        //fill code here.
        if (size == 0)
            System.out.println("No records found");
        else {
            System.out.format("%-15s %s\n", "Id", "Description");
            //fill code here.
        }
    }
}


