package com.groovy.example.Groovy_IntelliAssetManagement

class AssetManagementSystem {

    public static def userList = []
    public static def assetList = []

//This method is used to read the content from file and return that file's content as string.
    String readFileContent(String filename) {
        def xmlString = new File(filename).text
        return xmlString
    }

//This method is used to read the xmlString(xml file's content) and
//generate the user list from that xmlString. The method returns the user list.
    List<User> generateUserList(String xmlString) {
        def users = new XmlSlurper().parseText(xmlString)
        users.user.each { u ->
            userList.add(new User(Long.parseLong(u.id.text()), u.name.text(), u.department.text()))
        }
        return userList
    }

//This method is used to read the xmlString(xml file content) and generate the asset list
//from that xmlString. The method returns the asset list.
    List<Asset> generateAssetList(String xmlString) {
        def assets = new XmlSlurper().parseText(xmlString)
        assets.asset.each { a ->
            assetList.add(new Asset(Long.parseLong(a.id.text()),
                    a.category.text(),
                    a.type.text(),
                    Double.parseDouble(a.price.text()),
                    null,
                    true
            )
            )
        }
        return assetList
    }

//This method is used to find the user using the username and returns the user object.
    User obtainUser(String username) {
        def user = userList.find { u -> u.name == username }
        return user
    }

//This method is used to find weather the asset type is valid (which is present in xml file) or not.
//If it is valid then the method returns the asset object. Otherwise returns null.
    Asset isValidAssetType(String assetType) {
        def asset = assetList.find { a -> a.type == assetType }
        if (asset != null) {
            return asset
        } else {
            return null
        }
    }

//This method is used to return the asset list which are in available status for a given asset type.
    def obtainAvailableAsset(assetType) {
        def availableAssets = []
        availableAssets = assetList.findAll { a -> a.type == assetType && a.availability == true }[0]
        return availableAssets
    }

//This method is used to find the asset using asset id from the asset list.
//If any asset is in available status, then the method returns that asset object. Otherwise returns null.
    Asset obtainAsset(assetId, assList) {
        def asset = assetList.find { a -> a.id == Long.parseLong(assetId) }
        if (asset != null) {
            return asset
        } else {
            return null
        }
    }

//This method is used to assign the asset to that user, if it assign return true, otherwise returns false.
    Boolean assign(Asset asset, User user) {
        if (asset.availability == true) {
            asset.user = user
            asset.availability = false
            return true
        } else {
            return false
        }
    }

//This method is used to return the asset list, which is assigned by the particular user.
    List<Asset> obtainAssignedAssets(User user) {
        def assignedAssets = []
        assignedAssets = assetList.findAll { a -> a.user && a.user.id == user.id && a.availability == false }
        return assignedAssets
    }

//This method is used to unassign the asset from a user.
//If it is returned then the method returns true, otherwise returns false.
    Boolean returnAsset(Asset asset) {
        if (asset.availability == false) {
            asset.user = null
            asset.availability = true
            return true
        } else {
            return false
        }
    }
}

