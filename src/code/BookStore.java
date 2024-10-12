package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class models book store's information.
 * booksInTheUniverse() Reading text files and returns each line as a list of Strings andn populates the list of
 * novels. Populating the ArrayList with the novel data
 * and the HashMap with the novel titles as key, novel object as value.
 * printNovelsWithIterator() Iterating through the set of novel titles and prints each corresponding novel.
 * printNovelsWithoutThe() Printing novels whose titles do not contain the word "the".
 * printAllTitles() Printing all titles of books in uppercase.
 * printBookTitle() Printing all titles that contain the specified parameter.
 * printTitlesInAlphaOrder() Printing all titles in alphabetical order, A-Z.
 * printGroupByDecade() Printing all books for the inputted decade (e.g. input: 2000, output: print all book tittles
 * from 2000 to 2009)
 * getLongest() Finding the longest title in the bookstore.
 * isThereABookWrittenIn() Checking if there is a book written in the specified year.
 * howManyBooksContain() Returning the amount of Books that contain this word in their title.
 * whichPercentWrittenBetween() Getting a percentage of the books were written between these two years(inclusive).
 * getOldestBook() Returning the oldest book.
 * getBooksThisLength() Returning a list of all books whose title is this length.
 * main() drives BookStore class.
 *
 * @author Yujin Jeong
 * @author Neriyel Reyes
 * @author Brian Diep
 * @version 1.0
 */
public class BookStore
{

    private static int WITHIN_DECADE = 9;
    private static int PERCENTAGE_MULTIPLIER;

    private final String      nameOfBookStore;
    private final List<Novel> novels;

    /**
     * Constructor.
     *
     * @param nameOfBookStore name of book store
     */
    public BookStore(final String nameOfBookStore) throws FileNotFoundException
    {

        this.nameOfBookStore = nameOfBookStore;
        this.novels          = new ArrayList<>();

        booksInTheUniverse();
    }

    /**
     * Helper function for the BookStore constructor. Populates the novelReferences ArrayList<Novel>.
     * <p>
     * Scans the file until the last line. The while loop works on ONE LINE at a time. Each line is split via "|". The first index is the title, second the author, third the year published. Then the Novel object is created with those indices (in order). Finally, that Novel object is added to the novels ArrayList<Novel>.
     *
     * @return an ArrayList<Novel> that represents all the Novels in the library.
     *
     * @throws FileNotFoundException
     */
    private void booksInTheUniverse() throws FileNotFoundException
    {

        final File    file;
        final Scanner scan;

        file = new File("src/novels_list.txt");
        scan = new Scanner(file);

        while(scan.hasNextLine())
        {
            final String   line;
            final String[] currentLine;
            final String   title;
            final String   author;
            final int      year;
            final Novel    novel;

            line        = scan.nextLine();
            currentLine = line.split("\\|");
            title       = currentLine[0].trim();
            author      = currentLine[1].trim();
            year        = Integer.parseInt(currentLine[2].trim());

            novel = new Novel(title, author, year);
            novels.add(novel);
        }
    }

    //Methods

    /**
     * Printing all titles of books in uppercase.
     */
    final public void printAllTitles()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    sb.append(novel.getTitle().toUpperCase()).append("\n");
                }
            }

            System.out.println(sb);

        }
    }

    /**
     * Printing all titles that contain the specified parameter.
     *
     * @param title title of book
     */
    public void printBookTitle(final String title)
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null && novel.getTitle() != null)
                {
                    if(novel.getTitle().toUpperCase().contains(title.toUpperCase()))
                    {
                        builder.append(novel.getTitle()).append("\n");
                    }
                }
            }
        }
        System.out.println(builder);
    }

    /**
     * Printing all titles in alphabetical order, A-Z.
     */
    public void printTitlesInAlphaOrder()
    {

        final StringBuilder builder;
        builder = new StringBuilder();

        if(novels != null)
        {
            Collections.sort(novels);
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    builder.append(novel.getTitle()).append("\n");
                }
            }
        }
        System.out.println(builder);
    }

    /**
     * Printing all books for the inputted decade (e.g. input: 2000, output: print all book tittles from 2000 to 2009).
     */
    public void printGroupByDecade(final int decade)
    {

        final StringBuilder builder;
        builder = new StringBuilder();
        boolean hasBooksInDecade = false;

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    final int yearPublished;
                    yearPublished = novel.getYearPublished();

                    //Checks if yearPublished is valid and if it is within the decade entered (e.g. 2000 + 9 = 2009)
                    if(yearPublished >= decade && yearPublished <= (decade + WITHIN_DECADE))
                    {
                        builder.append(novel.getTitle()).append(" (").append(yearPublished).append(")\n");
                    }
                }
            }
            if(builder.isEmpty())
            {
                System.out.println(String.format("Sorry! No books found within the decade %d :/", decade));
            }
            System.out.println(builder);
        }
    }

    /**
     * Finding the longest title in the bookstore.
     */
    public void getLongest()
    {

        final StringBuilder builder;
        String              longestTitle;

        builder      = new StringBuilder();
        longestTitle = "";

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null && novel.getTitle() != null)
                {
                    if(novel.getTitle().length() > longestTitle.length())
                    {
                        longestTitle = novel.getTitle();
                    }
                }
            }
        }
        builder.append(longestTitle);
        System.out.println(builder);
    }

    /**
     * Checking if there is a book written in the specified year.
     *
     * @param year specified year
     *
     * @return boolean true if a book was written in the specified year
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    if(novel.getYearPublished() == year)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returning the amount of Books that contain this word in their title.
     *
     * @param word word
     */
    public void howManyBooksContain(final String word)
    {

        final StringBuilder builder;
        int                 counter;

        builder = new StringBuilder();
        counter = 0;

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    if(novel.getTitle().toLowerCase().contains(word.toLowerCase()))
                    {
                        counter++;
                    }
                }
            }
        }
        builder.append(counter);
        System.out.println(builder);
    }

    /**
     * Getting a percentage of the books were written between these two years(inclusive).
     *
     * @param first desired first year
     * @param last  desired last year
     */
    public void whichPercentWrittenBetween(final int first, final int last)
    {
        double percentageOfBooks;
        int    counter;

        counter = 0;

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    if(novel.getYearPublished() >= first && novel.getYearPublished() <= last)
                    {
                        counter++;
                    }
                }
            }
            percentageOfBooks = ((double) counter / novels.size()) * PERCENTAGE_MULTIPLIER;

            System.out.println(String.format("%.1f", percentageOfBooks));
        }
    }

    // TODO:Implement

    /**
     * Returning the oldest book.
     */
    public void getOldestBook()
    {

        final StringBuilder builder;
        builder = new StringBuilder();

    }

    // TODO:Implement

    /**
     * Returning a list of all books whose title is this length.
     *
     * @param titleLength book title length
     */
    public void getBooksThisLength(final int titleLength)
    {

        final StringBuilder builder;
        builder = new StringBuilder();

    }

    /**
     * Main driver.
     *
     * @param args unused
     */
    public static void main(final String[] args) throws FileNotFoundException
    {

        final BookStore bookStore;
        bookStore = new BookStore("Nariyal's Pandora Box");

        // TODO:Implement
        // Calls all the BookStore methods listed above
    }
}
