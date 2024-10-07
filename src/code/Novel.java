package code;

/**
 * This class models novel's information.
 * getTitle() a getter for title of book.
 * getAuthorName() a getter for author name.
 * getYearPublished() a getter for published year
 *
 * @author Yujin Jeong
 * @author Neriyel Reyes
 * @author Brian Diep
 * @version 1.0
 */
public class Novel {

    private final String    title;
    private final String    authorName;
    private final int       yearPublished;

    /**
     * Constructor.
     * @param title         title of book
     * @param authorName    author name
     * @param yearPublished published year
     */
    public Novel(final String title, final String authorName, final int yearPublished) {

        this.title          = title;
        this.authorName     = authorName;
        this.yearPublished  = yearPublished;

    }

    //Methods

    /**
     * Creating a getter for title of book.
     * @return title of book
     */
    public String getTitle(){
        return title;
    }

    /**
     * Creating a getter for author name.
     * @return author name
     */
    public String getAuthorName(){
        return authorName;
    }

    /**
     * Creating a getter for published year.
     * @return published year
     */
    public int getYearPublished() {
        return yearPublished;
    }
}
