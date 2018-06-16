package com.java.example.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {

  public static void main(String[] args) throws IOException {

    String csvFile = "asset.csv";
    String line = "";
    String delimiter = ",";

    FileWriter softwareFileWriter = new FileWriter("software.csv");
    FileWriter hardwareFileWriter = new FileWriter("hardware.csv");

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

      while ((line = br.readLine()) != null) {
        String[] country = line.split(delimiter);
        switch (country[3]) {
          case "hardware":
            hardwareFileWriter.write(country[0] + "," + country[1] + "," + country[2] + "\n");
            break;
          case "software":
            softwareFileWriter.write(country[0] + "," + country[1] + "," + country[2] + "\n");
            break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      softwareFileWriter.close();
      hardwareFileWriter.close();
    }
  }
}
