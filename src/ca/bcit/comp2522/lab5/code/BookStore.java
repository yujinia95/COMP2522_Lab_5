package ca.bcit.comp2522.lab5.code;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 * This class models book store's information.
 * booksInTheUniverse() Reading text files and returns each line as a list of Strings and populates the list of
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

    private static int WITHIN_DECADE         = 9;
    private static int PERCENTAGE_MULTIPLIER = 100;

    private final String                nameOfBookStore;
    private final List<Novel>           novels;

    /**
     * Constructor.
     *
     * @param nameOfBookStore name of book store
     *
     */
    public BookStore(final String nameOfBookStore)
    {

        this.nameOfBookStore = nameOfBookStore;
        this.novels          = new ArrayList<>();

        // Populating list with novels
        novels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        novels.add(new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        novels.add(new Novel("American Pastoral", "Philip Roth", 1997));
        novels.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        novels.add(new Novel("Animal Farm", "George Orwell", 1946));
        novels.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        novels.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        novels.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        novels.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        novels.add(new Novel("Atonement", "Ian McEwan", 2002));
        novels.add(new Novel("Beloved", "Toni Morrison", 1987));
        novels.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        novels.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        novels.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        novels.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        novels.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        novels.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        novels.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        novels.add(new Novel("Catch-22", "Joseph Heller", 1961));
        novels.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        novels.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        novels.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        novels.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        novels.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        novels.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        novels.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        novels.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        novels.add(new Novel("A Death in the Family", "James Agee", 1958));
        novels.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        novels.add(new Novel("Deliverance", "James Dickey", 1970));
        novels.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        novels.add(new Novel("Falconer", "John Cheever", 1977));
        novels.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        novels.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        novels.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        novels.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        novels.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        novels.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        novels.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        novels.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        novels.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        novels.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        novels.add(new Novel("Herzog", "Saul Bellow", 1964));
        novels.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        novels.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        novels.add(new Novel("I, Claudius", "Robert Graves", 1934));
        novels.add(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        novels.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        novels.add(new Novel("Light in August", "William Faulkner", 1932));
        novels.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        novels.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        novels.add(new Novel("Lord of the Flies", "William Golding", 1954));
        novels.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        novels.add(new Novel("Loving", "Henry Green", 1945));
        novels.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        novels.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        novels.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        novels.add(new Novel("Money", "Martin Amis", 1984));
        novels.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        novels.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        novels.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        novels.add(new Novel("Native Son", "Richard Wright", 1940));
        novels.add(new Novel("Neuromancer", "William Gibson", 1984));
        novels.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        novels.add(new Novel("1984", "George Orwell", 1948));
        novels.add(new Novel("On the Road", "Jack Kerouac", 1957));
        novels.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        novels.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        novels.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        novels.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        novels.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        novels.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        novels.add(new Novel("Possession", "A.S. Byatt", 1990));
        novels.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        novels.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        novels.add(new Novel("Rabbit, Run", "John Updike", 1960));
        novels.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        novels.add(new Novel("The Recognitions", "William Gaddis", 1955));
        novels.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        novels.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        novels.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        novels.add(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        novels.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        novels.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        novels.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        novels.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        novels.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        novels.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        novels.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        novels.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        novels.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        novels.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        novels.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        novels.add(new Novel("Ubik", "Philip K. Dick", 1969));
        novels.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        novels.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        novels.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        novels.add(new Novel("White Noise", "Don DeLillo", 1985));
        novels.add(new Novel("White Teeth", "Zadie Smith", 2000));
        novels.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));

//        // Populating map data with key and value
//        for (Novel novel : novels)
//        {
//            bookMap.put(novel.getTitle(), novel);
//        }
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
        longestTitle = null;

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null && novel.getTitle() != null)
                {

                    if(longestTitle == null || novel.getTitle().length() > longestTitle.length())
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

    /**
     * Returning the oldest book.
     */
    public Novel getOldestBook()
    {

        Novel oldestNovelSoFar;
        oldestNovelSoFar = novels.get(0);

        if(novels != null)
        {

            for(final Novel novel : novels)
            {

                if(novel != null)
                {
                    if(novel.getYearPublished() < oldestNovelSoFar.getYearPublished())
                    {
                        oldestNovelSoFar = novel;
                    }
                }
            }
        }
        return oldestNovelSoFar;

    }

    /**
     * Returning a list of all books whose title is this length.
     *
     * @param titleLength book title length
     */
    public List<Novel> getBooksThisLength(final int titleLength)
    {
        final List<Novel> bookWithThisLength;

        bookWithThisLength = new ArrayList<>();

        if(novels != null)
        {
            for(final Novel novel : novels)
            {
                if(novel != null)
                {
                    if(novel.getTitle().length() == titleLength)
                    {
                        bookWithThisLength.add(novel);
                    }
                }
            }
        }
        return bookWithThisLength;
    }

    public List<Novel> getNovelsList() {
        return novels;
    }

    /**
     * Main driver.
     *
     * @param args unused
     */
    public static void main(final String[] args) throws FileNotFoundException
    {

        final BookStore   bookStore;
        final List<Novel> fifteenCharTitles;

        bookStore = new BookStore("Nariyal's poochie Box"); Novel oldest;

        //Testing implemented methods
        /**
         * Printing all titles.
         */
        System.out.println("\n===All Titles in UPPERCASE===");
        bookStore.printAllTitles();

        /**
         *  Printing book titles containing 'the'.
         */
        System.out.println("===Book Titles Containing 'the'===");
        bookStore.printBookTitle("the");

        /**
         *  Printing all titles in alphabetical Order.
         */
        System.out.println("===All Titles in Alphabetical Order===");
        bookStore.printTitlesInAlphaOrder();

        /**
         *  Printing books from the 2000s
         */
        System.out.println("===Books from the 2000s===");
        bookStore.printGroupByDecade(2000);

        /**
         * Printing the longest Book Title.
         */
        System.out.println("===Longest Book Title===");
        bookStore.getLongest();

        /**
         * Printing if there is a book written in 1950?
         */
        System.out.println("\n===Is there a book written in 1950?===");
        System.out.println(bookStore.isThereABookWrittenIn(1950));

        /**
         * Printing how many books contain 'heart'.
         */
        System.out.println("\nHow many books contain 'heart'?");
        bookStore.howManyBooksContain("heart");

        /**
         * Printing percentage of books written between 1940 and 1950.
         */
        System.out.println("\n===Percentage of books written between 1940 and 1950===");
        bookStore.whichPercentWrittenBetween(1940, 1950);

        /**
         *  Printing the oldest book.
         */
        System.out.println("\n===Oldest book===");
        oldest = bookStore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + oldest.getYearPublished());

        /**
         * Printing books with titles 15 characters long.
         */
        System.out.println("\n===Books with titles 15 characters long===");
        fifteenCharTitles = bookStore.getBooksThisLength(15);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));

    }
}
