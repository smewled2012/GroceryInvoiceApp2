package com.objectoriented;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BonusGroceryApp {


    // this numeric to word conversion code is taken from the internet

    public static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",  "Eighteen", "Nineteen" };

    public static final String[] tens = {"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};



    public static String doubleConvert(final double n) {
        String pass = n + "";
        StringTokenizer token = new StringTokenizer(pass, ".");
        String first = token.nextToken();
        String last = token.nextToken();
        try {
            pass = convert(Integer.parseInt(first))+" ";
            pass=pass+"Dollars and ";
            for (int i = 0; i < last.length(); i++) {
                String get=convert(Integer.parseInt(last.charAt(i)+""));
                if(get.isEmpty()){
                    pass=pass+" "+"ZERO";
                }else{
                    pass=pass+" "+get;
                }
            }

        } catch (NumberFormatException nf) {
        }
        return pass;
    }

    public static String convert(final int n) {
        if (n < 0) {
            return "Minus " + convert(-n);
        }
        if (n < 20) {
            return units[n];
        }
        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }
        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }
        if (n < 100000) {
            return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
        }
        if (n < 10000000) {
            return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
        }
        return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }



    public static void main(String[] args){


        ArrayList<GroceryItems> itemList = new ArrayList<>();
      //  ArrayList<Double> totalCost = new ArrayList<>();
        double purAmount =0;

        System.out.println("Please Enter the Grocery Items ");
        String addItem;

        do {
            GroceryItems item = new GroceryItems();
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the name of the gocery item !");
            String name1 = input.nextLine();
            item.setName(name1);

            System.out.println("Enter the price of the grocery item !");
            double price1 = input.nextDouble();
            item.setPrice(price1);

          //  System.out.println("Please Enter the quantity of the item !");
            int random = (int )(Math. random() * 9 + 1);
            item.setQuantity(random);
            input.nextLine();

            System.out.println("Do you want put more Grocery Items ?");
            addItem = input.nextLine();

            itemList.add(item);

        } while (addItem.equalsIgnoreCase("yes"));


        System.out.println("\nItem Name \t\t\t\tPrice\t\t\t\tQuantity \t\t\t\tCost");

        for (GroceryItems items : itemList) {
            double cost = items.getPrice() * items.getQuantity();
            System.out.println(items.getName() + "\t\t\t\t\t" + "$" + items.getPrice() + "\t\t\t\t\t" + items.getQuantity() + "\t\t\t\t\t" + "$" + cost);
           // totalCost.add(cost);
            purAmount +=cost;

        }

        System.out.printf("\n\nTotal Purchase Amount = %f\n",purAmount);
        System.out.printf("Total Items Purchased:  %s\n\n",itemList.size());

        if(purAmount>20){
            System.out.println("You spent too much today...");
        }
        else{
            System.out.println("Thank you for shopping at my market!\n");
        }

        //converts the numeric to words

        System.out.println("The purchased amount in word : "+doubleConvert(purAmount)+" Cents ");






    }
}
