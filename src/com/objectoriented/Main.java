package com.objectoriented;

/* The program generates the Invoice of Grocery items purchased
* It first asks the user to enter the name , the price and the quantity of the grocery items purchased
* It asks if the user has more grocery items purchase if you say yes it will ask you to input the name , price and quantity of the other item
* Then it displays the item purchased in a table format with Item name , price , quantity and the cost of each item which is the product of
 * the price of the item and its quantity
 * calculates the total amount purchase and the number of purchased items then  displays it to the user
 *
 * */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<GroceryItems> itemList = new ArrayList<>();
        ArrayList<Double> totalCost = new ArrayList<>();
        double purAmount =0;

        System.out.println("Please Enter the Grocery Items ");
       String checking="";

       // asking the user for the input
        do {
            GroceryItems item = new GroceryItems();
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the name of the gocery item !");
            String name1 = input.nextLine();
            item.setName(name1);

            System.out.println("Enter the price of the grocery item !");
            double price1 = input.nextDouble();
            item.setPrice(price1);

            System.out.println("Please Enter the quantity of the item !");
            int quan = input.nextInt();
            item.setQuantity(quan);
            input.nextLine();


            System.out.println("Do you want put more Grocery Items ?");
            checking = input.nextLine();

            itemList.add(item);

        } while (checking.equalsIgnoreCase("yes"));


        System.out.println("\nItem Name \t\t\t\tPrice\t\t\t\tQuantity \t\t\t\tCost");

        // calculates the cost of the item and the total purchase
        for (GroceryItems items : itemList) {
            //calculate the cost of the item
            double cost = items.getPrice() * items.getQuantity();
            // displays the item name, price, quantity and cost of each item
            System.out.println(items.getName() + "\t\t\t\t\t" + "$" + items.getPrice() + "\t\t\t\t\t" + items.getQuantity() + "\t\t\t\t\t" + "$" + cost);
            totalCost.add(cost);
            purAmount +=cost;

        }

        //Displays the total purchase amount and items purchased
        System.out.printf("\n\nTotal Purchase Amount = %f\n",purAmount);
        System.out.printf("Total Items Purchased:  %s",itemList.size());


    }
}
