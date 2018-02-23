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
                    log_detail.put(logUserId, logDate);
                    logMap.put(logAssetId, log_detail);

//                    logMap.put(Date,(logMap.containsKey(Date)));
                }
            }


            for (Map.Entry<String, Map<String, String>> logEntry : logMap.entrySet()) {
                String logAssetKey = logEntry.getKey();
                System.out.println(logAssetKey);
                Map<String, String> logDetail = logMap.get(logAssetKey);
                Set<String> logUserKey = logDetail.keySet();
                System.out.println(logUserKey);

//                Map<String, String> userNameDept = userMap.get(logUserKey);
////                System.out.println(logAssetKey);
////                Map<String,String> logDetail = logMap.get(logAssetKey);
//                Set<String> userName = userNameDept.keySet();
//                System.out.println(userName);


                Map<String, String> asset_detail = assetMap.get(logAssetKey);

                Set<String> assetDetailKey = asset_detail.keySet();
                System.out.println(assetDetailKey);


//                String userenterkey1 = entry.getValue();
                //String asset_output = userenterkey + userenterkey1;
//                System.out.println(userenterkey+" with asset id "+userenterkey1+ " is assigned to " + );
            }
//            for (Map.Entry<Integer, String> entry : userMap.entrySet())
//            {
//                String userenterkey2 = entry.getKey();
//                String userenterkey3 = entry.getValue();
//                System.out.println(userenterkey2 +" "+ userenterkey3)
//
//            }
//            for (Map.Entry< Date > entry : logMap.entrySet())
//            {
//                String userenterkey4 = entry.getTextContent();
//                System.out.println(userenterkey4.format("dd-mm-yyyy"));
//
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}