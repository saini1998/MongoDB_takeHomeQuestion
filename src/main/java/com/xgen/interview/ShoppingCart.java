package com.xgen.interview;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This is the current implementation of ShoppingCart. Please write a
 * replacement
 */
public class ShoppingCart implements IShoppingCart {
    Map<String, Integer> contents = new LinkedHashMap<String, Integer>(); // used Linked HashMaps instead of hashMaps to
                                                                          // save the order of insertion
    Pricer pricer;

    public static long count = 0; // to keep track of print receipt function call

    public ShoppingCart(Pricer pricer) {
        this.pricer = pricer;
    }

    public void addItem(String itemType, int number) {

        if (!contents.containsKey(itemType)) {
            contents.put(itemType, number);
        } else {
            int existing = contents.get(itemType);
            contents.put(itemType, existing + number);
        }
    }

    public void printReceipt() {
        count++;
        Integer total = 0; // to get total amount
        Object[] keys = contents.keySet().toArray();
        if (count == 1) {
            for (int i = 0; i < Array.getLength(keys); i++) {
                Integer price = pricer.getPrice((String) keys[i]) * contents.get(keys[i]);
                total = total + price;
                Float priceFloat = new Float(new Float(price) / 100);
                String priceString = String.format("€%.2f", priceFloat);
                System.out.println(keys[i] + " - " + contents.get(keys[i]) + " - " + priceString); // print prices after
                                                                                                   // items
            }

        } else if (count == 2) {
            for (int i = 0; i < Array.getLength(keys); i++) {
                Integer price = pricer.getPrice((String) keys[i]) * contents.get(keys[i]);
                total = total + price;
                Float priceFloat = new Float(new Float(price) / 100);
                String priceString = String.format("€%.2f", priceFloat);
                System.out.println(priceString + " - " + contents.get(keys[i]) + " - " + keys[i]); // printing items
                                                                                                   // after prices
            }
            count = 0; // make count =0 for next test case

        }

        Float totalFloat = new Float(new Float(total) / 100);
        String totalString = String.format("€%.2f", totalFloat);
        System.out.println("Total" + " - " + totalString); // Total line to receipt, with full price to be charged from
                                                           // customer
    }
}