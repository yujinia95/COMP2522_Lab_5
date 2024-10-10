package tests;

import code.BookStore;


public class BookStoreTest
{
    public static void main(String[] args) {
        BookStore bookStore;
        bookStore = new BookStore("BCIT library");

        System.out.println("Test print titles in alpha order:\n");
        bookStore.printTitlesInAlphaOrder();

        System.out.println("Testing Print book title\n");
        bookStore.printBookTitle("Wide");

        System.out.println("Testing Decade (Exists)\n");
        bookStore.printGroupByDecade(2000);

        System.out.println("Testing Decade (Does not exist)\n");
        bookStore.printGroupByDecade(1900);
    }
}
