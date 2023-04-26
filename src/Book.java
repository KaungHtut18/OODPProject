import java.util.Date;

public class Book
{
    private String bookName="";
    private String author="";
    private String ISBN="";
    private boolean isBorrowed=false;
    private Date publishedDate=null;
    private String genre="";

    public Book(String isbn,Date publishedDate,String bookName,String author,boolean isBorrowed,String genre)
    {
        this.bookName = bookName;
        this.author = author;
        this.ISBN = isbn;
        this.isBorrowed = isBorrowed;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }
    public Book(String isbn,Date publishedDate,String bookName,String author,String genre)
    {
        this.bookName = bookName;
        this.author = author;
        this.ISBN = isbn;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        String status;
        if(isBorrowed)
            status="lent";
        else
            status="availble";
        return "Title: "+bookName+", Author: "+author+", ISBN: "+ISBN+", Status: "+status+", Genre: "+genre;
    }

    public Boolean getIsBorrowed()
    {
        return isBorrowed;
    }

    public String getISBN()
    {
        return this.ISBN;
    }

    public Date getPublishedDate()
    {
        return publishedDate;
    }

    public String getBookName()
    {
        return bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getGenre()
    {
        return genre;
    }
}
