import java.sql.*;
import java.util.Scanner;


public class LibrarianClient extends SqlCommands
{
    private Connection connection=null;

    public LibrarianClient(String username,String password)
    {
        this.connection=super.logIn(0,username,password);
    }


    public void addUser(int userClass, String userName,String passWord)
    {

        String hashedPW=BCrypt.hashpw(passWord,BCrypt.gensalt());

        Statement statement=null;
        try
        {
            PreparedStatement statement1 = connection.prepareStatement("insert into librarian(username,password) values(?,?)");
            PreparedStatement statement2 = connection.prepareStatement("insert into member(username,password) values(?,?)");
            int i=-1;
            if(userClass==0)
            {
                statement1.setString(1,userName);
                statement1.setString(2,hashedPW);
                i=statement1.executeUpdate();
            }
            else
            {
                statement2.setString(1, userName);
                statement2.setString(2, hashedPW);
                i = statement2.executeUpdate();
            }
            if(i==-1)
            {
                System.out.println("failed to add user");
            }
            else
                System.out.println("Added user succssfully");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
        }



    }


    public void addBook(String isbn, Date pubDate,String title,String author,String genre)
    {
        try
        {
            String sql="insert into books(isbn,publishedDate,bookName,author,genre) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,isbn);
            statement.setDate(2, pubDate);
            statement.setString(3,title);
            statement.setString(4,author);
            statement.setString(5,genre);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int userID)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            bookList.clear();
            String sql = "select * from books where borrowerID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,userID);
            ResultSet set = statement.executeQuery();
            while(set.next())
            {
                Book book = new Book(set.getString("isbn"),set.getDate("publishedDate"),set.getString("bookName"),
                        set.getString("author"),set.getString("genre"));
                bookList.add(book);
            }
            printBookList(bookList);

            System.out.println("Please choose the books that the user have returned");
            String index=scanner.nextLine();
            String books[]=index.split("[, ]");//will split if the user puts these characters

            String returnBookSql="update books set isReturned=1,borrowerID=default,lentMember=default, returnDate=default,lentDate=default where isbn=?";
            PreparedStatement s=connection.prepareStatement(returnBookSql);
            int returnedBookCount=0;
            for (String book:books)
            {
                Book b=bookList.get(Integer.parseInt(book)-1);
                s.setString(1,b.getISBN() ); ;
                returnedBookCount+=s.executeUpdate();
            }
            System.out.println(returnedBookCount+"book(s) have been returned");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }


}
