import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LibrarianMain
{
    String userName=null;
    String passWord=null;
    LibrarianClient librarianClient=null;//PRELOADING USER AND LIBRARIAN CLIENT OBJECTS
    Connection currentSession=null;//WELCOME MESSAGE

    public void start()
    {

        Scanner scanner=new Scanner(System.in);
        boolean isLogin=false;
        do
        {
            System.out.println("Please enter your username: ");
            userName=scanner.nextLine();
            System.out.println("Please enter your password");
            passWord=scanner.nextLine();


                librarianClient = new LibrarianClient(userName, passWord);
                currentSession = librarianClient.getConnection();
                if (currentSession != null)
                {
                    isLogin = true;
                    System.out.println("login successful! Welcome " + librarianClient.getUserName());
                    System.out.println();
                } else
                    System.out.println("login failed. Please try again.");

        }while(!isLogin);
        menu(librarianClient);

    }
    public void menu(LibrarianClient client)
    {
        System.out.println("What would you like to do?\n" +
                "1.Add new member\n" +
                "2.Add new books\n" +
                "3.Search books\n" +
                "4.Show all books\n" +
                "5.Return books\n" +
                "6.exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice)
        {
            case 1:
                System.out.println("Please enter username of the new member");
                String userName=scanner.nextLine();
                System.out.println("PLease enter the password of the new member");
                String passWord=scanner.nextLine();
                client.addUser(1,userName,passWord);
                menu(client);
                break;
            case 2:
                System.out.println("Please enter the ISBN number of the book");
                String isbn=scanner.nextLine();
                System.out.println("Please enter the name of the book");
                String title=scanner.nextLine();
                System.out.println("Please enter the author of the book");
                String author=scanner.nextLine();
                System.out.println("Please enter the published date in YYYY-MM-DD format ");
                String date =scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date pubDate=null;
                try
                {
                    java.util.Date utilDate=dateFormat.parse(date);
                    pubDate = new java.sql.Date(utilDate.getTime());
                }catch(ParseException e)
                {
                    System.out.println(e.getMessage());
                }
                System.out.println("Please enter the genre of the book");
                String genre= scanner.nextLine();
                client.addBook(isbn,pubDate,title,author,genre);
                menu(client);
                break;
            case 3:
                System.out.println("Please enter Author,Title or ISBN number of the name");
                String value=scanner.nextLine();
                client.search(value);
                menu(client);
                break;
            case 4:
                client.getAllBooks();
                break;
            case 5:
                System.out.println("Please enter the userID of the member returning the book");
                int id=scanner.nextInt();
                client.returnBook(id);
                break;
            case 6:
                System.out.println("Good bye");
                scanner.close();
                break;

        }

    }




}
