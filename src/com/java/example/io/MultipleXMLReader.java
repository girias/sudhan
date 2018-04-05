package com.java.example.io;

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
            File userInputFile = new File("user.xml");
            File assetInputFile = new File("asset.xml");
            File logInputFile = new File("log.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document userDoc = dBuilder.parse(userInputFile);
            Document assetDoc = dBuilder.parse(assetInputFile);
            Document logDoc = dBuilder.parse(logInputFile);

            userDoc.getDocumentElement().normalize();
            assetDoc.getDocumentElement().normalize();
            logDoc.getDocumentElement().normalize();

            Map<String, Map<String, String>> userMap = new LinkedHashMap<>();
            Map<String, Map<String, String>> assetMap = new LinkedHashMap<>();
            Map<String, Map<String, String>> logMap = new LinkedHashMap<>();

            NodeList aList = assetDoc.getElementsByTagName("asset");
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
                }
            }


            NodeList uList = userDoc.getElementsByTagName("user");
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

            NodeList lList = logDoc.getElementsByTagName("log");
            for (int temp = 0; temp < lList.getLength(); temp++) {
                Node lNode = lList.item(temp);
                if (lNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) lNode;

                    String logDate = eElement.getElementsByTagName("date").item(0).getTextContent();
                    String logUserId = eElement.getElementsByTagName("userid").item(0).getTextContent();
                    String logAssetId = eElement.getElementsByTagName("assetid").item(0).getTextContent();

                    Map<String, String> log_detail = new HashMap<>();
                    log_detail.put(logUserId, logDate);
                    logMap.put(logAssetId, log_detail);

                }
            }

            String userName = null;
            String date = null;
            String userId = null;

            for (Map.Entry<String, Map<String, String>> logEntry : logMap.entrySet()) {
                String logAssetKey = logEntry.getKey();
                Map<String, String> logDetail = logMap.get(logAssetKey);
                Set<String> logUserKey = logDetail.keySet();
                userId = logUserKey.toString().replace("[", "").replace("]", "");
                for (String key : logUserKey) {
                    date = logDetail.get(key);
                    Map<String,String> userDetail = userMap.get(key);
                    userName = userDetail.keySet().toString().replace("[", "").replace("]", "");
                }

                Map<String, String> asset_detail = assetMap.get(logAssetKey);

                String assetName = asset_detail.keySet().toString().replace("[", "").replace("]", "");
                System.out.println(assetName + " with asset id " + logEntry.getKey() + " is assigned to " + userName + " with user id " + userId + " at " + date);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}