package com.example.arrays;

import java.util.Scanner;

public class OneDTwoDArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of input items: ");
        int inputNumberOfItems = scanner.nextInt();

        int[] numberOfItems = new int[inputNumberOfItems];
        System.out.print("Enter the price for" + inputNumberOfItems + ": ");

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 1;

        for (int i=0;i < inputNumberOfItems; i++) {
            numberOfItems[i] = scanner.nextInt();
            if(numberOfItems[i] > 0 && numberOfItems[i] <= 25){
                count1 ++;
            } else if(numberOfItems[i] > 0 && numberOfItems[i] <= 50) {
                count2 ++;
            } else if(numberOfItems[i] > 0 && numberOfItems[i] <= 100) {
                count3 ++;
            } else if(numberOfItems[i] > 0 && numberOfItems[i] <= 500) {
                count4 ++;
            } else if(numberOfItems[i] > 0 && numberOfItems[i] <= 1000) {
                count5 ++;
            } else if (numberOfItems[i] >= 1000 || numberOfItems[i] < 1) {
                System.out.println("Invalid input");
                count6 = 0;
                break;
            }
        }

        if(count6 == 1) {
            System.out.println("The number of items between 0 to 25 :" + count1);
            System.out.println("The number of items between 25 to 50 :" + count2);
            System.out.println("The number of items between 50 to 100 :" + count3);
            System.out.println("The number of items between 100 to 500 :" + count4);
            System.out.println("The number of items between 500 to 1000 :" + count5);
        }

    }
}
