package com.example.OOPSConcept;

public class PrivilegeRoleBO {

    void displayRoleDetailsByPrivilege(PrivilegeRole[] privilegeRole, String privilege) {


    }

    void displayRole(Role[] roles) {
        System.out.format("%-15s %s\n", "Id", "Name");
        for (int i = 0; i < roles.length; i++) {
            System.out.format("%-15s %s\n", roles[i].getId(), roles[i].getName());
        }
    }

    void displayPrivilege(Privilege[] privilege) {
        System.out.format("%-15s %s\n", "Id", "Name");
        for (int i = 0; i < privilege.length; i++) {
            System.out.format("%-15s %s\n", privilege[i].getId(), privilege[i].getName());
        }
    }

    void displayPrivilegeDetailsByRole(PrivilegeRole[] privilegeRole, String role) {

    }
}
