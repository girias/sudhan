package com.groovy.example.Groovy_ReportManagement

class ReportManagement {


    public static List<Category> categoryData = new ArrayList<>()

    public static List<Asset> assetData = new ArrayList<>()

    public static List<User> userData = new ArrayList<>()

    public static List<Log> listLog = new ArrayList<>()


    static String readFileContent(String filename) {

        String fileContents = new File(filename).text

        return fileContents


    }


    static User validateUserById(Long userId) {

        User user = null



        user = userData.find {


            it.getId() == userId

        }





        return user

    }


    static List<User> loadUsers(String xmlString) {


        def user = new XmlParser().parseText(xmlString)

        user.user.findAll { p ->

            userData.add(new User(Long.parseLong(p.id[0].text()), p.name[0].text(), p.department[0].text()))

        }


    }


    static void loadAssets(String xmlString) {


        def asset = new XmlParser().parseText(xmlString)

        asset.asset.findAll { p ->

            assetData.add(new Asset(Long.parseLong(p.number[0].text()), p.name[0].text(), p.categoryId[0].text(), Double.parseDouble(p.price[0].text()), ""))

        }


    }


    static List<Category> loadCategories(String xmlString) {

        def category = new XmlParser().parseText(xmlString)

        category.category.findAll { p ->

            Long id = Long.parseLong(p.id[0].text())

            String name = p.name[0].text()

            categoryData.add(new Category(id, name))

        }

    }


    static File createFileObject(String fileName) {


        return new File(fileName)

    }


    static void loadLog(File file) {


        file.eachLine { line ->

            if (line != null) {

                listLog.add(line)

            }

        }


    }


    static List<Asset> findAssetsOfCategory(Long categoryId) {


        List<Asset> data = new ArrayList<>()

        assetData.each {


            if (it.getCategory().equalsIgnoreCase(String.valueOf(categoryId))) {

                data.add(it)

            }


        }



        return data

    }


    static List<Asset> findAvailableAssetsOfCategory(Long categoryId) {


        List<Asset> data = new ArrayList<>()

        assetData.each {


            if (it.getCategory().equalsIgnoreCase(String.valueOf(categoryId))) {

                data.add(it)

            }


        }



        return data

    }


    static List<Asset> currentlyAssignedAssetsForUser(Long userId) {

        List<Asset> data = new ArrayList<>()

        listLog.each { l ->

            String[] split = l.split(",")

            if (userId == Long.parseLong(split[1]) && split[2].equalsIgnoreCase("Assigned")) {

                assetData.each { a ->

                    if (a.getNumber() == Long.parseLong(split[0])) {

                        data.add(a)

                    }

                }


            }

        }

        return data

    }


    static List<Log> allCurrentlyAssignedAssets() {

        List<Log> data = new ArrayList<>()

        List<Log> returnedData = new ArrayList<>()



        assetData.each { a ->


            Long number = a.getNumber()



            listLog.each { l ->

                String[] split = l.split(",")

                if (number == Long.parseLong(split[0]) && split[2].equalsIgnoreCase("Assigned")) {


                    data.add(l)


                }

                if (number == Long.parseLong(split[0]) && split[2].equalsIgnoreCase("Returned")) {

                    //println("Retunred data>>" + l);

                    returnedData.add(l)

                }


            }


        }

        //remove the returned entry from the list and return the log list with assigned data only

        List<Log> sortedData = data.sort { a, b ->

            Date.parse("dd-MM-yyyy", a.split(",")[3]) <=> Date.parse("dd-MM-yyyy", b.split(",")[3])


        }

        //println(sortedData)

        returnedData.each { r ->


            String[] split = r.split(",")

            String assetNumber = split[0]

            String catId = split[1]

            String date = split[3]





            sortedData.removeAll {


                String[] s = it.split(",")

                s[0].equals(assetNumber) && (Date.parse("dd-MM-yyyy", date) >= Date.parse("dd-MM-yyyy", s[3]))


            }


        }



        return sortedData

    }


}

