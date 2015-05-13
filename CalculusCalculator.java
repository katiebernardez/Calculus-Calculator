import java.util.*;

public class CalculusCalculator
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      introMessage();
      String operationType = getOperationType(input);
      Equation e = getEquation(input, operationType);
      System.out.println(e);
      System.out.println();
      if(operationType.equalsIgnoreCase("integrate")) {
         e.integrate();
      } 
      else if(operationType.equalsIgnoreCase("differentiate")) {
         e.differentiate();
      }
      System.out.println("Here is your new equation: " + e.toString());         
   }
   
   public static void introMessage()
   {
      System.out.println("Hello! Welcome to the Calculus Calculator."); 
      System.out.println("We are here to help you with your math homework."); 
      System.out.println();     
   }

//all methods used by all types of equations   
   public static Equation getEquation(Scanner input, String operationType)
   {
      String equationType = getEquationType(input);
      Equation e;
      //if(equationType.equalsIgnoreCase("polynomial")) {
      int degree = getPolynomialDegree(input);
      List<Double> coefficients = getPolynomialCoefficients(input, degree);
      e = new Polynomial(coefficients);
      //} 
   //       else if(equationType.equalsIgnoreCase("trigonometric")) {
   //          
   //       }
      return e;
   }
   
   public static Equation getInsideFunction(Scanner input, String operationType)
   {
      Equation inside;
      if(operationType.equalsIgnoreCase("integrate")) {
         System.out.println("Inside the function, you may have only a polynomial of up to 1st degree");
         int degree=getInt(input, "Choose polynomial degree (0 or 1): ", 0, 1);
         List<Double> coefficients = getPolynomialCoefficients(input, degree);
         inside = new Polynomial(coefficients);
      } 
      else {
         System.out.println("Inside the function, you may have any other type of equation");
         inside = getEquation(input, operationType);
      }
      return inside;
   }
   
   public static String getEquationType(Scanner input)
   {
      String prompt = "Type of equation (polynomial, trigonometric, or exponential): ";
      System.out.print(prompt);
      String equationType = "";
      
      equationType = input.next();
      
      while(!(equationType.equalsIgnoreCase("polynomial") || equationType.equalsIgnoreCase("trigonometric") || equationType.equalsIgnoreCase("exponential")))
      {
         System.out.println("Input is not valid, you need to enter polynomial, trigonometric, or exponential");
         System.out.print(prompt);
         input.nextLine();
         equationType = input.next();
      }
      input.nextLine();
      return equationType;
   }
   
   public static String getOperationType(Scanner input)
   {
      String prompt = "Integrate or Differentiate: ";
      System.out.print(prompt);
      String operationType = "";
      
      operationType = input.next();
      
      while(!(operationType.equalsIgnoreCase("integrate") || operationType.equalsIgnoreCase("differentiate")))
      {
         System.out.println("Input is not valid, you need to enter either integrate or differentiate");
         System.out.print(prompt);
         input.nextLine();
         operationType = input.next();
      }
      input.nextLine();
      return operationType;  
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
   
   /**
    *This method robutly retrieves an integer
    *@param input the scanner used to get input
    *@param prompt the string the user sees before entering anything
    *@param min the smallest number the user can enter
    *@param max the largest number the user can enter
    *@return the integer
    */
   public static int getInt(Scanner input, String prompt, int min, int max)
   {
      System.out.print(prompt);
      int newInt=0;
      while (newInt==0)
      {
         while (!input.hasNextInt()) //while an int hasn't been entered
         {
            System.out.println("Input is not valid, you need to enter a number"); //tell the user that the input was invalid
            System.out.print(prompt); //ask them to enter their guess again
            input.nextLine(); //reset the scanner
         }
         newInt=input.nextInt();
         if (newInt<min || newInt>max) //if input is out of range
         {
            System.out.println("Input is not valid, you need to enter a number between "+min+" and "+max); //tell the user
            System.out.print(prompt); //reprompt them
            newInt=0; //set newInt to 0 so the loop runs again
            input.nextLine(); //reset the scanner
         }
      }
      input.nextLine(); //reset the scanner
      return newInt;
   }
   
//all methods used for polynomials specifically
   public static int getPolynomialDegree(Scanner input)
   {
      int degree = getPositiveInt(input, "Polynomial degree: ");
      return degree;
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

//all methods used for trig functions specifically
   public static String getTrigFunction(Scanner input)
   {
      String prompt = "Choose trig function (sin, cos, tan, csc, sec, cot): ";
      System.out.print(prompt);
      String trigType = "";
      
      trigType = input.next();
      
      while(!(trigType.equalsIgnoreCase("sin") || trigType.equalsIgnoreCase("cos") || trigType.equalsIgnoreCase("tan")
           || trigType.equalsIgnoreCase("csc") || trigType.equalsIgnoreCase("sec") || trigType.equalsIgnoreCase("cot")))
      {
         System.out.println("Input is not valid, you need to enter sin, cos, tan, csc, sec, or cot");
         System.out.print(prompt);
         input.nextLine();
         trigType = input.next();
      }
      input.nextLine();
      return trigType;
   }

//all methods used for exponential functions specifically

}