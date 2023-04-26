import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the Library!\n" +
            "Which account would you like to log in as?\n" +
            "1.Librarian\n" +
            "2.Member");
        boolean isInputOk=true;
        int choice=0;
        do{
            try
            {
                 choice=scanner.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please only enter either 1 or 2");
                scanner.next();
                isInputOk=false;
            }
        }while(!isInputOk);


        scanner.nextLine();

        if(choice ==1)
        {
            LibrarianMain main = new LibrarianMain();
            main.start();
        }
        else
        {
            UserMain main = new UserMain();
            main.start();
        }

    }
}