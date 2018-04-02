package com.java.example.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DomParserDemo2 {

   public static void main(String[] args) {

      try {
         File userinputFile = new File("user.xml");
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

         Map<String, List<String>> userMap = new LinkedHashMap<>();
         Map<String, List<String>> assetMap = new LinkedHashMap<>();
         Map<String, List<String>> logMap = new LinkedHashMap<>();

//         NodeList assetList = assetdoc.getElementsByTagName("asset");

//         for (int temp = 0; temp < assetList.getLength(); temp++) {
//             Node aNode = assetList.item(temp);
//             if (aNode.getNodeType() == Node.ELEMENT_NODE) {
//                 Element eElement = (Element) aNode;
//                 Integer asset_id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
//                 String asset_name = eElement.getElementsByTagName("name").item(0).getTextContent();
//            }
//         }
//         NodeList uList = userdoc.getElementsByTagName("user");
//         for (int temp = 0; temp < uList.getLength(); temp++) {
//             Node uNode = assetList.item(temp);
//             if (uNode.getNodeType() == Node.ELEMENT_NODE) {
//                 Element eElement = (Element) uNode;
//                 Integer user_id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
//                 String cust_name = eElement.getElementsByTagName("name").item(0).getTextContent();
//            }
//        }

         NodeList logList = logdoc.getElementsByTagName("log");
         for (int temp = 0; temp < logList.getLength(); temp++) {
             Node lNode = logList.item(temp);
             if (lNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) lNode;
                 String assetId = eElement.getElementsByTagName("assetid").item(0).getTextContent();
                 String userId = eElement.getElementsByTagName("userid").item(0).getTextContent();
                 String assetDate = eElement.getElementsByTagName("date").item(0).getTextContent();
                 logMap.put(assetId,Arrays.asList(userId,assetDate));
//                 System.out.println(logMap);
             }
        }

          NodeList assetList = assetdoc.getElementsByTagName("asset");
          for (int temp = 0; temp < assetList.getLength(); temp++) {
              Node assetNode = assetList.item(temp);
              if (assetNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) assetNode;
                  String assetId = eElement.getElementsByTagName("id").item(0).getTextContent();
                  String assetName = eElement.getElementsByTagName("name").item(0).getTextContent();
                  String assetPrice = eElement.getElementsByTagName("price").item(0).getTextContent();
                  assetMap.put(assetId,Arrays.asList(assetName,assetPrice));

              }
          }

          NodeList userList = userdoc.getElementsByTagName("user");
          for (int temp = 0; temp < userList.getLength(); temp++) {
              Node userNode = userList.item(temp);
              if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) userNode;
                  String userId = eElement.getElementsByTagName("id").item(0).getTextContent();
                  String userName = eElement.getElementsByTagName("name").item(0).getTextContent();
                  String userDepartment = eElement.getElementsByTagName("department").item(0).getTextContent();
                  userMap.put(userId,Arrays.asList(userName,userDepartment));
              }
          }

          System.out.println(logMap);
          System.out.println(assetMap);
          System.out.println(userMap);

//          logMap.forEach(log -> logMap.);

//             System.out.println(asset_name+" asset id "+asset_id+" is assigned to "+user_name+" with user id "+user_id+" at "+aDate.format("dd-MM-yyyy"));

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}