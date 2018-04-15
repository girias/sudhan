package com.groovy.example.Groovy_IntelliMachineChoice

import java.text.SimpleDateFormat

class Main {

    static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
        ReportManagement RM = new ReportManagement()

//loading all files
        RM.loadCategories(RM.readFileContent("category.xml"))
        RM.loadUsers(RM.readFileContent("user.xml"))
        RM.loadAssets(RM.readFileContent("asset.xml"))
        RM.loadLog(new File("log.csv"))

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        println("1. The summary report")
        println("2. View all available assets of a category")
        println("3. View all currently assigned assets of an employee")
        println("4. View all currently assigned assets")
        println("5. View all assets of a category")
        println("Enter your choice:")

        Integer choice = new Integer(br.readLine())

        switch (choice) {
            case 1:
                println("Total number of assets:" + RM.assetList.size())
                println("Total number of users:" + RM.userList.size())
                println("Total number of categories:" + RM.categoryList.size())
//Frequent Assigned Asset
                RM.logList.countBy { it.asset.number }.sort { -it.value }.eachWithIndex { l, i ->
                    if (i <= 0) {
                        println "Frequently assigned assets:"
                        def AssignedAssets = RM.assetList.find { aL -> aL.number == Long.parseLong(l.toString().split("=")[0]) }.name
                        println AssignedAssets
                        println "Frequent consumers:"
                        RM.logList.sort { it.user.name }.findAll { it ->
                            it.asset.number == Long.parseLong(l.toString().split("=")[0])
                        }.unique { aL -> aL.user.name }.each { lL ->
                            println lL.user.name
                        }
                    }
                }
                break

            case 2:
                println("Enter category id")
                def categoryId = Long.parseLong(br.readLine())
                if (categoryId != null) {
                    RM.findAssetsOfCategory(categoryId).each { aL ->
                        println(aL.number + " - " + aL.name)
                    }
                } else {
                    println "Invalid category id"
                }
                break

            case 3:
                println("Enter user id:")
                def userId = Long.parseLong(br.readLine())
                def validUserID = RM.validateUserById(userId)
                if (validUserID != null) {
                    RM.currentlyAssignedAssetsForUser(userId).each { aL ->
                        println(aL.number + "-" + aL.name)
                    }
                } else {
                    println "Invalid user id"
                }
                break

            case 4:
                RM.allCurrentlyAssignedAssets().each { aL ->
                    println(aL.asset.number + "-" + aL.user.name + "-" + new SimpleDateFormat("dd-MM-yyyy").format(aL.date))
                }
                break

            case 5:
                println("Enter category id:")
                def categoryId = Long.parseLong(br.readLine())
                RM.findAvailableAssetsOfCategory(categoryId).each { aL ->
                    println(aL.number + "-" + aL.name)
                }
                break
        }
    }
}

