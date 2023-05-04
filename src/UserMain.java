import java.sql.Connection;
import java.util.Scanner;

public class UserMain
{
    public void start()
    {
        String userName=null;
        String passWord=null;
        UserClient client=null;//PRELOADING USER AND LIBRARIAN CLIENT OBJECTS
        Connection currentSession=null;//WELCOME MESSAGE
        Scanner scanner=new Scanner(System.in);
        boolean isLogin=false;
        do
        {
            System.out.println("Please enter your username: ");
            userName=scanner.nextLine();
            System.out.println("Please enter your password");
            passWord=scanner.nextLine();


            client = new UserClient(userName, passWord);
            currentSession = client.getConnection();
            if (currentSession != null)
            {
                isLogin = true;
                System.out.println("login successful! Welcome " + client.getUserName());
                System.out.println();
            } else
                System.out.println("login failed. Please try again.");

        }while(!isLogin);
        menu(client);

    }
    private void menu(UserClient client)
    {
        Scanner s= new Scanner(System.in);
        int i=0;
        System.out.print("===What would you like to do?===\n" +
                "1.Browse books\n" +
                "2.Search books\n" +
                "3.Borrow book\n" +
                "4.Check borrowed books\n" +
                "5.Exit: ");
        i=s.nextInt();
        switch(i)
        {
            case 1:client.getAllBooks();
                menu(client);
                break;

            case 2:
                s.nextLine();
                System.out.println("Please enter Author,Title or ISBN number of the name");
                String value=s.nextLine();
                client.search(value);
                menu(client);
                break;

            case 3:
                if(client.getBookList()==null)
                    {
                        System.out.println("No books have been loaded to memmory yet. Please use the command '1'or '2' first.");
                        menu(client);
                    }
                else
                {
                    System.out.println("Please enter the book number from the list above");
                    int bookNum=s.nextInt();
                    client.borrowBook(client.getBookList().get(bookNum-1));
                    menu(client);
                }
                break;
            case 4:client.printBookList(client.getBorrowedBook());
                menu(client);
                break;

            case 5:
                System.out.println("Thank you for using the system");
                break;



        }

    }


}
