package com.java.example.streams;

import java.io.*;

public class InvoiceBO {

    void  findAllRejectedPayments(String inputfilename, File outputfile) {

        try {
            FileInputStream fileInputStream = new FileInputStream(inputfilename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String strline;
            StringBuffer sb = new StringBuffer();
            FileWriter writer = new FileWriter(outputfile);

            while ((strline = bufferedReader.readLine()) != null)
            {
                String[] data = strline.split(",");

                if (data[6].equalsIgnoreCase("Rejected")){
                    sb.append(data[0]);
                    sb.append(",");
                    sb.append(data[2]);
                    sb.append(",");
                    sb.append(data[1]);
                    sb.append(",");
                    sb.append(data[5]);
                    sb.append(",");
                    sb.append(data[6]);
                }
                if(sb.length() > 0) {
                    writer.write(sb.toString());
                    writer.write("\n");
                    sb.delete(0, sb.length());
                }

            }

            fileInputStream.close();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }

    }
}
