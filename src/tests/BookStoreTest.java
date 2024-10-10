package tests;

import code.BookStore;


public class BookStoreTest
{
    public static void main(String[] args) {
        BookStore bookStore;
        bookStore = new BookStore("BCIT library");

        bookStore.printTitlesInAlphaOrder();
        System.out.println("Testing Print book title\n");
        bookStore.printBookTitle("Wide");
    }
}
