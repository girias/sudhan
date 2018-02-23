package com.example.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MultipleXMLReader {

    public static void main(String[] args) {

        try {
            File userinputFile = new File("users.xml");
            File assetinputFile = new File("asset.xml");
            File loginputFile = new File("log.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document userdoc = dBuilder.parse(userinputFile);
            Document assetdoc = dBuilder.parse(assetinputFile);
            Document logdoc = dBuilder.parse(loginputFile);

            userdoc.getDocumentElement().normalize();
            assetdoc.getDocumentElement().normalize();
            logdoc.getDocumentElement().normalize();

            Map<String, Map<String, String>> userMap = new LinkedHashMap<>();
            Map<String, Map<String, String>> assetMap = new LinkedHashMap<>();
            Map<String, Map<String, String>> logMap = new LinkedHashMap<>();

            NodeList aList = assetdoc.getElementsByTagName("asset");
            for (int temp = 0; temp < aList.getLength(); temp++) {
                Node aNode = aList.item(temp);
                if (aNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) aNode;
                    String assetId = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String assetName = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String asset_price = eElement.getElementsByTagName("price").item(0).getTextContent();
                    Map<String, String> asset_detail = new HashMap<>();
                    asset_detail.put(assetName, asset_price);
                    assetMap.put(assetId, asset_detail);
                    //assetMap.put(asset_id,(assetMap.containsKey(asset_id)));

                }
            }


            NodeList uList = userdoc.getElementsByTagName("user");
            for (int temp = 0; temp < uList.getLength(); temp++) {
                Node uNode = uList.item(temp);
                if (uNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) uNode;
                    String userId = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String userName = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String userDepartment = eElement.getElementsByTagName("department").item(0).getTextContent();

                    Map<String, String> user_detail = new HashMap<>();
                    user_detail.put(userName, userDepartment);
                    userMap.put(userId, user_detail);
                }
            }

            NodeList lList = logdoc.getElementsByTagName("log");
            for (int temp = 0; temp < lList.getLength(); temp++) {
                Node lNode = lList.item(temp);
                if (lNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) lNode;

                    String logDate = eElement.getElementsByTagName("date").item(0).getTextContent();
                    String logUserId = eElement.getElementsByTagName("userid").item(0).getTextContent();
                    String logAssetId = eElement.getElementsByTagName("assetid").item(0).getTextContent();

                    Map<String, String> log_detail = new HashMap<>();
//                    System.out.println(logUserId);
//                    System.out.println(logDate);
                    log_detail.put(logUserId, logDate);
                    logMap.put(logAssetId, log_detail);

//                    logMap.put(Date,(logMap.containsKey(Date)));
                }
            }

            StringBuffer sb = new StringBuffer();
            String userName = null;
            String date = null;

            for (Map.Entry<String, Map<String, String>> logEntry : logMap.entrySet()) {
                String logAssetKey = logEntry.getKey();
//                System.out.println("Asset ID: " + logAssetKey);
                Map<String, String> logDetail = logMap.get(logAssetKey);
                Set<String> logUserKey = logDetail.keySet();
                for (String key : logUserKey) {
                    date = logDetail.get(key);
//                    System.out.println("Date : " + logDetail.get(key));
                    Map<String,String> userDetail = userMap.get(key);
                    Set<String> userNameKey = userDetail.keySet();
                    userName = userDetail.keySet().toString();
//                    userNameKey.toString().replace("[", "");
//                    userNameKey.toString().replace("]", "");
//                    System.out.println("user Name: " + userNameKey);
//                    userNameKey.forEach( nameKey -> System.out.println(userDetail.get(nameKey)));
                }

                Map<String, String> asset_detail = assetMap.get(logAssetKey);

                Set<String> assetDetailKey = asset_detail.keySet();
//                System.out.println(">>>" + assetDetailKey);
//              Computer with asset id 24577896 is assigned to Johnson with user id 87568 at 03-08-2017
//                sb.append(asset_detail.keySet() +" with asset id "+logEntry.getKey()+ " is assigned to " + userName +" with user id " + logUserKey + " at " + date);
//                sb.toString().replaceAll("\\[", "");
//                sb.toString().replaceAll("\\]", "");
                System.out.println(asset_detail.keySet() + " with asset id " + logEntry.getKey() + " is assigned to " + userName + " with user id " + logUserKey + " at " + date);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}