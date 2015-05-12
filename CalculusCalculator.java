import java.util.*;

public class CalculusCalculator
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      introMessage();
      String equation = getEquationType(input);
      System.out.println();
      //if(equation.equals("polynomial") {
         int degree = getPolynomialDegree(input);
         System.out.println();
         List<Double> coefficients = getPolynomialCoefficients(input, degree);
         System.out.println();
      //} else { 
      
   }
   
   public static void introMessage()
   {
      System.out.println("Hello! Welcome to the Calculus Calculator."); 
      System.out.println("We are here to help you with your math homework."); 
      System.out.println();     
   }
   
   public static String getEquationType(Scanner input)
   {
      String prompt = "Type of equation (polynomial, trigonometric, or exponential): ";
      System.out.print(prompt);
      String equationType = "";
      
      equationType = input.next();
      
      while(!(equationType.equalsIgnoreCase("polynomial") || equationType.equalsIgnoreCase("trigonometric") || equationType.equalsIgnoreCase("exponential")))
      {
         System.out.println("Input is not valid, you need to enter either polynomial, trigonometric, or exponential");
         System.out.print(prompt);
         input.nextLine();
         equationType = input.next();
      }
      input.nextLine();
      return equationType;
   }
   
   public static int getPolynomialDegree(Scanner input)
   {
      int degree = getPositiveInt(input, "Polynomial degree: ");
      return degree;
   }
   
   public static int getPositiveInt(Scanner input, String prompt)
   {
      System.out.print(prompt);
      int newInt = 0;
      while (newInt == 0)
      {
         while (!input.hasNextInt()) //while an int hasn't been entered
         {
            System.out.println("Input is not valid, you need to enter an integer"); //tell the user that the input was invalid
            System.out.print(prompt); //ask them to enter their guess again
            input.nextLine(); //reset the scanner
         }
         newInt = input.nextInt();
         if (newInt < 0) //if input is out of range
         {
            System.out.println("Input is not valid, you need to enter a positive number or 0"); //tell the user
            System.out.print(prompt); //reprompt them
            newInt = 0; //set newInt to 0 so the loop runs again
            input.nextLine(); //reset the scanner
         }
      }
      input.nextLine(); //reset the scanner
      return newInt;
   }
   
   public static List<Double> getPolynomialCoefficients(Scanner input, int degree)
   {
      List<Double> coefficients = new ArrayList<Double>();
      for(int ii = 0; ii <= degree; ii++)
      {
         String prompt = "Coefficient of x^" + ii + " term: ";
         double coefficient = getDouble(input, prompt);
         coefficients.add(coefficient);
      } 
      return coefficients; 
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
      double newDouble = 0;
      while (!input.hasNextDouble()) //while a double hasn't been entered
      {
         System.out.println("Input is not valid, you need to enter a number"); //tell the user that the input was invalid
         System.out.print(prompt); //ask them to enter their guess again
         input.nextLine(); //reset the scanner
      }
      newDouble = input.nextDouble();
         
      input.nextLine(); //reset the scanner
      return newDouble;
   }
}