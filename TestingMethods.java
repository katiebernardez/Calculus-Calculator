import java.util.*;

public class TestingMethods
{
   public static void main(String[] args)
   {
      Scanner input=new Scanner(System.in);
      System.out.println(getEquationType(input));
   }
   
   public static String getEquationType(Scanner input)
   {
      String prompt="prompt: ";
      System.out.print(prompt);
      String equationType="";
      equationType=input.next();
      while(!equationType.equals("polynomial") || !equationType.equals("trigonometric") || !equationType.equals("exponential"))
      {
         System.out.println("Input is not valid");
         System.out.print(prompt);
         equationType=input.next();
         input.nextLine();
      }
      equationType=input.next();
      input.nextLine();
      return equationType;
   }
   
   /**
    *This method robutly retrieves a double
    *@param input the scanner used to get input
    *@param prompt the string the user sees before entering anything
    *@return the double
    */
   public static double getDouble(Scanner input, String prompt)
   {
      System.out.print(prompt);
      double newDouble=0;
      while (!input.hasNextDouble()) //while a double hasn't been entered
      {
         System.out.println("Input is not valid, you need to enter a number"); //tell the user that the input was invalid
         System.out.print(prompt); //ask them to enter their guess again
         input.nextLine(); //reset the scanner
      }
      newDouble=input.nextDouble();
         
      input.nextLine(); //reset the scanner
      return newDouble;
   }

}