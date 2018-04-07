package com.java.example.Groovy_IntelliAssetManagement

class Main {

    static void main(String[] args) {

        def user, username, asset, availableAsset = []
        def assetType
//defining object for class AssetManagementSystem
        AssetManagementSystem a = new AssetManagementSystem()

        String userFileName = "user.xml"
//loading user.xml
        def userList = a.generateUserList(a.readFileContent(userFileName))

        String assetFileName = "asset.xml"
//loading asset.xml
        def assetList = a.generateAssetList(a.readFileContent(assetFileName))

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        while (true) {
            println "1. Assign"
            println "2. Return"
            println "3. Exit"
            println "Enter the choice:"
// reading choice from user to perform above three opeartions
            int choice = new Integer(br.readLine())
            switch (choice) {
                case 1:
// defining the steps for "Assign" operation
                    while (true) {
                        println "Enter username:"
                        username = br.readLine()
                        user = a.obtainUser(username)
                        if (user != null) {
                            break
                        } else {
                            println "Invalid username"
                        }
                    }
                    while (true) {
                        println "Enter asset type:"
                        assetType = br.readLine()
                        def validAsset = a.isValidAssetType(assetType)
                        if (validAsset != null) {
                            asset = a.obtainAvailableAsset(assetType)
                            if (asset != null) {
                                a.assign(asset, user)
                                println "${assetType} with id ${asset.id} is successfully assigned to ${user.name}"
                            } else {
                                println "${assetType} is not available"
                            }
                            break
                        } else {
                            println "Invalid asset type"
                        }
                    }
                    break

                case 2:
                    println "Enter username:"
                    username = br.readLine()
                    user = a.obtainUser(username)
                    while (true) {
                        if (user == null) {
                            println "Invalid username"
                        } else {
                            def assignedUsers = a.obtainAssignedAssets(user)
                            assignedUsers.each { aU -> println aU.id }
                            break
                        }
                    }
                    while (true) {
                        println "Enter asset id:"
                        def assetID = br.readLine()
                        asset = a.obtainAsset(assetID, assetList)
                        if (asset != null) {
                            a.returnAsset(asset)
                            println "${asset.type} is returned by ${user.name}"
                            break
                        } else {
                            println "Invalid asset Id"
                        }
                    }
                    break

                case 3:
// exit from the main program
                    System.exit(0)
                    break
            }
        }
    }
}
