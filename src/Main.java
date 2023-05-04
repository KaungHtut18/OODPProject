import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("===Welcome to the Library!===\n" +
            "Which account would you like to log in as?\n" +
            "1.Librarian\n" +
            "2.Member");
        boolean isInputOk=true;
        String input;
        do{
           input=scanner.next();
          if(input.equals("1")||input.equals("2"))
          {
             break;
          }
            else
          {
              System.out.println("PLease enter only 1 or 2");
              isInputOk=false;
          }


        }while(!isInputOk);
        int choice=Integer.parseInt(input);

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