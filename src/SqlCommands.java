import java.sql.*;
import java.util.ArrayList;

public class SqlCommands
{
    protected String userName="";
    protected  Connection connection=null;
    ArrayList<Book> bookList= new ArrayList<Book>();
    protected Connection logIn(int userClass,String username, String password)//if log in is ok, will return the connection and if not will return null
    {
        Connection temp=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            temp = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","kaung19");
            Statement statement;
            statement = temp.createStatement();
            ResultSet set;
            if(userClass==0)//0 is for librarian
                 set= statement.executeQuery("Select * from librarian where username=\""+username+"\"");
            else//1 is for member
                set= statement.executeQuery("Select * from member where username=\""+username+"\"");
            String pw=null; //to get the hashed password from the table
            while(set.next())
            {

                pw=set.getString("password");
                if(BCrypt.checkpw(password,pw))
                {
                    this.userName=set.getString("username");
                    System.out.println("login ok");
                    connection=temp;
                    return temp;
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    protected Connection getConnection()
    {
        return connection;
    }
    public String getUserName()
    {
        return userName;
    }

    protected void search(String value)//can input title, author or isbn or user id to find the correspoding book
    {
        bookList.clear();
        //search with parameter by using SQL fuzzy search in case user had a typo
        try
        {
            Statement statement;
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM books WHERE bookname LIKE '%"+value+"%' OR author LIKE '%"+value+"%' OR isbn ='"+value+"' OR borrowerID='"+value+"';");

                while(set.next())
                {
                    Book book = new Book(set.getString(2),set.getDate(3),set.getString(4),set.getString(5),set.getBoolean(9),set.getString(10));
                    bookList.add(book);
                }
           if(bookList.isEmpty())
                System.out.println("No result found");
           else

               printBookList(bookList);

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());

        }
    }
    protected void getAllBooks()
    {
        bookList.clear();
        try
        {
            PreparedStatement statement = connection.prepareStatement("select * from books");
            ResultSet set=statement.executeQuery();
            while(set.next())
            {
                Book book = new Book(set.getString(2),set.getDate(3),set.getString(4),set.getString(5),set.getBoolean(9),set.getString(10));
                bookList.add(book);
            }
            printBookList(bookList);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    protected ArrayList<Book> getBookList()
    {
        return this.bookList;
    }



    protected void printBookList(ArrayList<Book> list)
    {
        if(list.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        int i=1;
        for (Book book:list)
        {

            System.out.println(i+". "+book.toString());
            i+=1;
        }
    }


}
