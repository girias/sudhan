package com.example.oops;

import java.io.BufferedReader;

public class ScrumMaster extends User {

    public ScrumMaster(String name, String userName, String password, String role) {
        super(name, userName, password, role);
    }


    public void createBacklog(BufferedReader br, Requirement[] requirement) throws Exception {
        int i, size = 0;
        //fill code here.
        System.out.println("Enter the number of requirement to create :");
        int noOfRequirement = Integer.parseInt(br.readLine());
        for (i = 0; i < noOfRequirement; i++) {
            System.out.println("Enter the id and description " + (i + 1) + ":");
            //fill code here.
        }
    }

    public Integer countTotalReqmts(Requirement[] requirement) {
        //fill code here
        return 0;
    }

    public Boolean assignreqmts(BufferedReader br, Requirement[] requirement, User user[])
            throws Exception {
        String assignDetail;
        int i, size = 0;
        for (i = 0; i < requirement.length; i++) {
            if (requirement[i] != null)
                size++;
        }

        //fill code here.

        System.out.println("Enter the requirement id and user name :");
        assignDetail = (br.readLine());

        for (i = 0; i < size; i++) {
            if (Integer.parseInt(assignDetail.split(",")[0]) == requirement[i].getId()) {
                //fill code here.
            }
        }
        return false;
    }
}


