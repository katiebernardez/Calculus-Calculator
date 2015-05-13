import java.util.*;

public abstract class Equation
{   
   public Equation()
   {
   
   }
      
   abstract String differentiate();
   
   abstract String integrate();
   
   protected double round(double number)
   {
      double rounded=(double) Math.round(number*1000)/1000;
      return rounded;
   }  
}