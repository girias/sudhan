package com.java.example.Groovy_ReportManagement

class Main {

    static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        println "1. The summary report"

        println "2. View all available assets of a category"

        println "3. View all currently assigned assets of an employee"

        println "4. View all currently assigned assets"

        println "5. View all assets of a category"





        println "Enter your choice:"

        Integer choice = new Integer(br.readLine())

        ReportManagement.loadAssets(ReportManagement.readFileContent("asset.xml"))

        ReportManagement.loadCategories(ReportManagement.readFileContent("category.xml"))

        ReportManagement.loadUsers(ReportManagement.readFileContent("user.xml"))

        ReportManagement.loadLog(new File("log.csv"))

        switch (choice) {

            case 1:



                List<String> maxAssignedAssetName = new ArrayList<>()

                List<String> maxConsumerName = new ArrayList<>()

                Map<String, Integer> assetCountDetails = new TreeMap<>()

                Map<String, Integer> consumerCountDetails = new TreeMap<>()



                ReportManagement.listLog.each { asset ->


                    String[] split = asset.split(",")



                    if (split[2].equalsIgnoreCase("Assigned")) {


                        if (assetCountDetails.get(split[0]) == null) {

                            assetCountDetails.put(split[0], 1)

                        } else {

                            assetCountDetails.put(split[0], assetCountDetails.get(split[0]) + 1)

                        }


                    }



                    if (consumerCountDetails.get(split[1]) == null) {

                        consumerCountDetails.put(split[1], 1)

                    } else {

                        consumerCountDetails.put(split[1], consumerCountDetails.get(split[1]) + 1)

                    }


                }

                int maxAssetOccurance = assetCountDetails.values().max()

                int maxConsumerOccurance = consumerCountDetails.values().max()

                assetCountDetails.each { k, v ->


                    if (v == maxAssetOccurance) {


                        ReportManagement.assetData.each { cat ->

                            if (cat.getNumber() == Long.parseLong(k)) {

                                maxAssignedAssetName.add(cat.getName())

                            }


                        }


                    }


                }



                consumerCountDetails.each { k, v ->


                    if (v == maxConsumerOccurance) {

                        ReportManagement.userData.each { user ->

                            if (user.getId() == Long.parseLong(k)) {

                                maxConsumerName.add(user.getName())

                            }

                        }

                    }

                }



                println("Total number of assets:" + ReportManagement.assetData.size())

                println("Total number of users:" + ReportManagement.userData.size())

                println("Total number of categories:" + ReportManagement.categoryData.size())

                println("Frequently assigned assets:")

                maxAssignedAssetName.each {

                    println(it)

                }

                println("Frequent consumers:")

                maxConsumerName.each {

                    println(it)

                }

                break

            case 5:



                println "Enter category id"

                Long catId = Long.parseLong(br.readLine())

                Map<Long, String> macthData = new TreeMap<>()

                ReportManagement.findAssetsOfCategory(catId).each { cat ->

                    macthData.put(cat.getNumber(), cat.getName())

                }

                if (macthData.size() > 0) {

                    macthData.each { k, v ->

                        println(k + " - " + v)

                    }

                } else {

                    println("Invalid category id")

                }







                break



            case 3:

                println "Enter user id:"

                Long userID = Long.parseLong(br.readLine())

                Map<Long, String> macthData = new TreeMap<>()

                ReportManagement.currentlyAssignedAssetsForUser(userID).each { cat ->

                    macthData.put(cat.getNumber(), cat.getName())

                }

                if (ReportManagement.validateUserById(userID) != null) {

                    macthData.each { k, v ->

                        println(k + " - " + v)

                    }

                } else {

                    println("Invalid employee id")

                }





                break



            case 4:

                List<Log> assignedData = ReportManagement.allCurrentlyAssignedAssets()



                List<Log> sortedData = ReportManagement.listLog.sort { a, b ->

                    Date.parse("dd-MM-yyyy", a.split(",")[3]) <=> Date.parse("dd-MM-yyyy", b.split(",")[3]) ?: Long.parseLong(a.split(",")[0]) <=> Long.parseLong(b.split(",")[0])


                }

                //println(sortedData)

                //println(assignedData)

                Map<String, String> data = new HashMap<>()



                assignedData.each { a ->

                    sortedData.each { b ->

                        if (a.split(",")[0].equals(b.split(",")[0])) {

                            if (!data.containsKey(a.split(",")[0])) {

                                String userName = ""

                                ReportManagement.userData.each {


                                    if (it.getId() == Long.parseLong(b.split(",")[1])) {

                                        userName = it.getName()


                                    }

                                }

                                data.put(b.split(",")[0], b.split(",")[0] + "," + userName + "," + b.split(",")[3])

                            }

                        }

                    }

                }



                List<String> finalData = new ArrayList<>()



                data.each { k, v ->


                    finalData.add(v)

                }



                finalData.sort { a, b ->

                    Date.parse("dd-MM-yyyy", a.split(",")[2]) <=> Date.parse("dd-MM-yyyy", b.split(",")[2]) ?: Long.parseLong(a.split(",")[0]) <=> Long.parseLong(b.split(",")[0])


                }.each {

                    println(it.replaceAll(",", "-"))

                }







                break



            case 2:

                println "Enter category id"

                Long catId = Long.parseLong(br.readLine())

                Map<Long, String> macthData = new TreeMap<>()

                ReportManagement.findAssetsOfCategory(catId).each { cat ->

                    macthData.put(cat.getNumber(), cat.getName())

                }



                if (macthData.size() > 0) {

                    macthData.each { k, v ->

                        println(k + " - " + v)

                    }

                } else {

                    println("Invalid category id")

                }

                break

            default:

                break

        }

    }

}


