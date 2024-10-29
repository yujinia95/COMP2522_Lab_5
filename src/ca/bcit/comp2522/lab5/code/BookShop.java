package ca.bcit.comp2522.lab5.code;

import java.awt.print.Book;
import java.util.*;

public class BookShop
{
    private final Map<String, Novel> bookMap;

    public BookShop(final BookStore bookStore)
    {

        this.bookMap = new HashMap<>();

        // Populating map data with key and value
        for (Novel novel : bookStore.getNovelsList())
        {
            bookMap.put(novel.getTitle(), novel);
        }

        // Remove Novels with "the" in title
        removeNovelsWithTitle();

    }

    private void removeNovelsWithTitle()
    {
        final Set<String>      allKeys;
        final Iterator<String> it;

        allKeys                 = bookMap.keySet();
        it                      = allKeys.iterator();

        System.out.println("\n=== Iterate the set of books without the book title 'the'===");

        while(it.hasNext())
        {
            final String titles;
            titles = it.next();
            if(titles.toLowerCase().contains("the"))
            {
                it.remove();
            }
        }

        final List<String> keyList;
        keyList = new ArrayList<>(allKeys);

        Collections.sort(keyList);
        for(String title : keyList)
        {

            final Novel novel;
            novel = bookMap.get(title);
            System.out.println(novel.toString());
        }
    }

    public static void main(final String[] args)
    {
        BookStore bookStore = new BookStore("Test store");
        BookShop bs = new BookShop(bookStore);
    }
}

