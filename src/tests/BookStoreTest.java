package tests;

import code.BookStore;

import java.io.FileNotFoundException;

public class BookStoreTest
{
    public static void main(String[] args) throws FileNotFoundException
    {
        BookStore bookStore;
        bookStore = new BookStore("BCIT library");

        System.out.println("---------- Test print titles in alpha order: ----------");
        bookStore.printTitlesInAlphaOrder();

        System.out.println("---------- Testing Print book title with 'Wide': ----------");
        bookStore.printBookTitle("Wide");


        System.out.println("---------- Testing Decade with '2000' (Exists): ----------");
        bookStore.printGroupByDecade(2000);

        System.out.println("---------- Testing Decade '1900' (Does not exist): ----------");
        bookStore.printGroupByDecade(1900);

        System.out.println("---------- Finding the longest title: ----------");
        bookStore.getLongest();

        System.out.println("---------- Percentage of Books in between: ----------");
        bookStore.whichPercentWrittenBetween(1935, 2000);
    }
}
