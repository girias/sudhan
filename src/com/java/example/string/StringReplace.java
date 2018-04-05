package com.java.example.string;

import java.util.Scanner;

public class StringReplace {

    public static void main(String[] args) {

        String inputString = new Scanner(System.in).nextLine();
        String stringToFind = new Scanner(System.in).nextLine();
        String stringToReplace = new Scanner(System.in).nextLine();

        System.out.println(inputString.replaceAll(stringToFind,stringToReplace));
    }
}