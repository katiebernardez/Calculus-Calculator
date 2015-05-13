import java.util.*;

public class Polynomial extends Equation
{
   private List<Double> coefficients;
   
   public Polynomial(List<Double> coefficients)
   {
      this.coefficients = coefficients;
   }
   
   public String toString()
   {
      String polynomial = "";
      if(coefficients.get(0) == null) {
         polynomial += "C";
      } else {
         polynomial += coefficients.get(0); }
      for(int ii = 1; ii < coefficients.size(); ii++)
      {
         polynomial += (" + ") + coefficients.get(ii) + "x^" + ii;  
      }
      return polynomial;
   }
   
   public String differentiate()
   {
      for(int ii = 0; ii < coefficients.size(); ii++)
      {
         coefficients.set(ii, coefficients.get(ii) * ii);
      }
      coefficients.remove(0);
      return this.toString();     
   }
   
   public String integrate()
   {
      for(int ii = 0; ii < coefficients.size(); ii++)
      {
         coefficients.set(ii, round(coefficients.get(ii) / (ii + 1)));
      }
      coefficients.add(0, null);
      return this.toString();
   }
}