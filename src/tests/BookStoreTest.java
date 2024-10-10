package tests;

import code.BookStore;


public class BookStoreTest
{
    public static void main(String[] args) {
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
    }
}
