import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class tester
{
    public static void main(String[] args)
    {
        String userName=null;
        String passWord=null;
        LibrarianClient librarianClient=null;//PRELOADING USER AND LIBRARIAN CLIENT OBJECTS
        UserClient userClient=null;
        Connection currentSession=null;//WELCOME MESSAGE
        System.out.println("Welcome to the Library!\n" +
                "Which account would you like to log in as?\n" +
                "1.Librarian\n" +
                "2.Member");
        Scanner scanner=new Scanner(System.in);

        int input = scanner.nextInt();
        scanner.nextLine();

        boolean islogin=false;

        do
        {
            System.out.println("Please enter your username: ");
            userName=scanner.nextLine();
            System.out.println("Please enter your password");
            passWord=scanner.nextLine();

            if (input == 1)//LOGIN PROCESS
            {
                librarianClient = new LibrarianClient(userName, passWord);
                currentSession = librarianClient.getConnection();
                if (currentSession != null)
                {
                    islogin = true;
                    System.out.println("login successful! Welcome " + librarianClient.getUserName());
                    System.out.println();
                } else
                    System.out.println("login failed. Please try again.");
            } else
            {
                userClient = new UserClient(userName, passWord);
                currentSession = userClient.getConnection();
                if (currentSession != null)
                {
                    islogin = true;
                    System.out.println("login successful! Welcome " + userClient.getUserName());
                    System.out.println();
                } else
                    System.out.println("login failed. Please try again.");
            }
        }
        while(!islogin);



        //client.printBookList();
        //client.addBook("123456","2000-9-10","testbook","mr tester","programming");
        //client.addUser(0,"Amanda","Amanda007");
    }
}
