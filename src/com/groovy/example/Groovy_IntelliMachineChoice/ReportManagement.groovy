package com.groovy.example.Groovy_IntelliMachineChoice

import java.text.SimpleDateFormat

class ReportManagement {

    public static def assetMap = [:]
    public static def userAssetMap = [:].withDefault { [] }
    public static def userList = []
    public static def categoryList = []
    public static def logList = []
    public static def assetList = []
    public static def returnList = []
    public static def assignedList = []

//*1 This method is used to read the content from the file and return that file content as string.
    String readFileContent(String filename) {
        def xmlString = new File(filename).text
        return xmlString
    }

//*2 This method is used to check if the User id is valid, If valid,
// then method returns user Object, otherwise returns null
    User validateUserById(long userId) {
        return userList.find { u -> u.id.toString() == userId.toString() }
    }

//*3 This method is used to read that xmlString(xml file content) and generate the user list from that xmlString.
    void loadUsers(String xmlString) {
        def users = new XmlSlurper().parseText(xmlString)
        users.user.each { u ->
            userList.add(new User(Long.parseLong(u.id.text()), u.name.text(), u.department.text()))
        }
    }

//*4 This method is used to read that xmlString(xml file content) and generate the asset list from that xmlString.
    void loadAssets(String xmlString) {
        def assets = new XmlSlurper().parseText(xmlString)
        assets.asset.each { a ->
            assetList.add(new Asset(Long.parseLong(a.number.text()),
                    a.name.text(),
                    categoryList.find { cl ->
                        cl.id == (Long.parseLong(a.categoryId.text()))
                    },
                    Double.parseDouble(a.price.text())))
        }
    }

//*5 This method is used to read that xmlString(xml file content) and generate the categories list from that xmlString
    void loadCategories(String xmlString) {
        def categories = new XmlSlurper().parseText(xmlString)
        categories.category.each { c ->
            categoryList.add(new Category(Long.parseLong(c.id.text()), c.name.text()))
        }
    }

//*6 This method creates an file object
    File createFileObject(String filename) {
        def file = new File(filename)
        return file
    }

//*7 This method will load the file content into the list
    void loadLog(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
        file.eachLine { line ->
            String[] s = line.split(",")
            def a = assetList.find { aL -> aL.number == Long.parseLong(s[0]) }
            def u = validateUserById(Long.parseLong(s[1]))
            if (u != null && (s[2] == "Assigned" || s[2] == "Renewed")) {
                userAssetMap[(u.id)] << a
            }
            if (s[2] == "Assigned") {
                a.status = s[2]
            } else if (s[2] == "Returned") {
                a.status = ""
            }
            logList.add(new Log(
                    a,
                    u,
                    s[2],
                    sdf.parse(s[3]))
            )
        }
    }

//*8 This method wil find the asset by category
    List<Asset> findAssetsOfCategory(long categoryId) {
        def availableAsset = []
        availableAsset = assetList.findAll { aL -> aL.category.id == categoryId }.sort { it -> it.number }
        return availableAsset
    }

//*9 This meth9od will find the available asset based on category
    List<Asset> findAvailableAssetsOfCategory(long categoryId) {
        return assetList.findAll { aL ->
            aL.category.id == categoryId
        }.sort { it -> it.number }
    }

//*10 This method is used to find all the assets, which is assigned to the parameterised user
    List<Asset> currentlyAssignedAssetsForUser(long userId) {
        return userAssetMap[userId].unique { u -> u.number }
    }

//*11 This method is used to find all the log based on the Assigned and
// Renewed assets(compare asset->number with log->asset->number) and return the log list.
    List<Log> allCurrentlyAssignedAssets() {
        def assignedLogs = []
        assetList.findAll { aL -> aL.status == "Assigned" }.each {
            aL ->
                assignedLogs << logList.findAll { lL -> lL.asset.number == aL.number && lL.action == "Assigned" }.sort {
                    it.date
                }[0]
        }
        return assignedLogs.sort { aL -> aL.date }
    }
}
