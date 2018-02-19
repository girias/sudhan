package com.example.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

   public static void main(String[] args) {

      try {
         File inputFile = new File("invoice.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         Map<String, Double> customerMap = new HashMap<>();

         NodeList nList = doc.getElementsByTagName("invoice");
         for (int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 String cust_name = eElement.getElementsByTagName("customer").item(0).getTextContent();
                 Double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()); // example String
                 customerMap.put(cust_name, (customerMap.containsKey(cust_name) ? price + customerMap.get(cust_name) : price));
             }
         }
         //Java 7
         for (Map.Entry<String,Double> entry : customerMap.entrySet()){
             System.out.println(entry.getKey() + " : " + entry.getValue());
         }
         //Java 8
//         customerMap.keySet().forEach(key -> System.out.println(key + " : " + customerMap.get(key)));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}