import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserClient extends SqlCommands
{
    private String userName="";
    private int userID=0;
    private Connection connection=null;
    ArrayList<Book> borrowedBook=new ArrayList<>();

    public ArrayList<Book> getBorrowedBook()
    {
        return borrowedBook;
    }

    public UserClient(String username,String password)
    {
        this.connection=super.logIn(1,username,password);
        this.userName=username;
        try
        {
            Statement statement = connection.createStatement();
            ResultSet set=statement.executeQuery("select id from member where username='"+userName+"'");
            while (set.next())
            {
                userID=set.getInt("id");
            }
            PreparedStatement ps=connection.prepareStatement("select * from books where lentMember='"+this.userName+"'");
            ResultSet bookSet=ps.executeQuery();
            while(bookSet.next())
            {
                Book book = new Book(bookSet.getString(2),bookSet.getDate(3),bookSet.getString(4),bookSet.getString(5),bookSet.getBoolean(9),bookSet.getString(10));
                book.setReturnDate(bookSet.getDate("returnDate"));
                this.borrowedBook.add(book);
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void borrowBook(Book book)
    {

        Scanner scanner=new Scanner(System.in);
        try
        {
            String sqlShowInfo="select * from books where isbn='"+book.getISBN()+"'";
            String sql="update books set borrowerID=?,lentDate=?,returnDate=?,lentMember=?,isReturned=0 where isbn=?";
            PreparedStatement statement = connection.prepareStatement(sqlShowInfo);
            ResultSet set=statement.executeQuery();
            while(set.next())
            {
                System.out.println("would you like to borrow this book?"+set.getString("bookName")+" Written by "+set.getString("author")+"?\n" +
                        "Y/N");
            }
            String response=scanner.nextLine();
            if(response.toLowerCase().equals("y"))
            {
                statement=connection.prepareStatement(sql);
                LocalDate date=LocalDate.now();
                Date returnDate=Date.valueOf(date.plusDays(7));
                statement.setInt(1,userID);
                statement.setDate(2, Date.valueOf(date));//current lent date
                statement.setDate(3, returnDate);//due date
                statement.setString(4,userName);
                statement.setString(5,book.getISBN());
                int i=statement.executeUpdate();
                if(i>0)
                {
                    System.out.println("Borrowed successfully! Please return by: "+date.plusDays(7));
                    System.out.println(book.toString());
                    book.setReturnDate(returnDate);
                    this.borrowedBook.add(book);
                }
            }


        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
