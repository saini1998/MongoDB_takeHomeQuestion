package com.xgen.interview;

import com.xgen.interview.Pricer;
import com.xgen.interview.ShoppingCart;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class ShoppingCartFeatures {
    public static int counter = 0;

    public void addingItem(ShoppingCart sc, String itemName, Integer itemNumber) {
        sc.addItem(itemName, itemNumber);

    }

    public void printingItem(ShoppingCart sc, String finalPrint) throws InterruptedException {
        counter++;
        if (counter == 1) {
            final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(myOut));

            sc.printReceipt();
            assertEquals(finalPrint, myOut.toString());
        } else if (counter == 2) {
            Thread.sleep(1000);
            int i;
            for (i = 0; i < 50; i++) {
                System.out.print("\b");
            }
            final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(myOut));

            sc.printReceipt();
            assertEquals(finalPrint, myOut.toString());
            counter = 0;
        }

    }

}

class ContentCheck extends ShoppingCartFeatures {

    public void canAddAnItem() throws InterruptedException {
        ShoppingCart sc = new ShoppingCart(new Pricer());
        addingItem(sc, "apple", 1);
        String finalResult = String.format("apple - 1 - €1.00%nTotal - €1.00%n");
        printingItem(sc, finalResult);
        String finalResult2 = String.format("€1.00 - 1 - apple%nTotal - €1.00%n");
        printingItem(sc, finalResult2);
    }

    public void canAddMoreThanOneItem() throws InterruptedException {
        ShoppingCart sc = new ShoppingCart(new Pricer());
        addingItem(sc, "apple", 2);
        String finalResult = String.format("apple - 2 - €2.00%nTotal - €2.00%n");
        printingItem(sc, finalResult);
        String finalResult2 = String.format("€2.00 - 2 - apple%nTotal - €2.00%n");
        printingItem(sc, finalResult2);
    }

    public void canAddDifferentItems() throws InterruptedException {
        ShoppingCart sc = new ShoppingCart(new Pricer());
        addingItem(sc, "apple", 2);
        addingItem(sc, "banana", 1);
        String finalResult = String.format("apple - 2 - €2.00%nbanana - 1 - €2.00%nTotal - €4.00%n");
        printingItem(sc, finalResult);
        String finalResult2 = String.format("€2.00 - 2 - apple%n€2.00 - 1 - banana%nTotal - €4.00%n");
        printingItem(sc, finalResult2);
    }

    public void doesntExplodeOnMysteryItem() throws InterruptedException {
        ShoppingCart sc = new ShoppingCart(new Pricer());
        addingItem(sc, "crisps", 2);
        String finalResult = String.format("crisps - 2 - €0.00%nTotal - €0.00%n");
        printingItem(sc, finalResult);
        String finalResult2 = String.format("€0.00 - 2 - crisps%nTotal - €0.00%n");
        printingItem(sc, finalResult2);
    }

}

public class ShoppingCartTest extends ContentCheck {

    @Test
    @Override
    public void canAddAnItem() throws InterruptedException {
        // TODO Auto-generated method stub
        super.canAddAnItem();
    }

    @Test
    @Override
    public void canAddMoreThanOneItem() throws InterruptedException {
        // TODO Auto-generated method stub
        super.canAddMoreThanOneItem();
    }

    @Test
    @Override
    public void canAddDifferentItems() throws InterruptedException {
        // TODO Auto-generated method stub
        super.canAddDifferentItems();
    }

    @Test
    @Override
    public void doesntExplodeOnMysteryItem() throws InterruptedException {
        // TODO Auto-generated method stub
        super.doesntExplodeOnMysteryItem();
    }
}