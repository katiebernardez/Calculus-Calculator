import java.util.*;

public class Polynomial extends Equation
{
   private List<Double> coefficients;
   
   public static void main(String[] args)
   {
      List<Double> list = new ArrayList<Double>();
      list.add(1.0);
      list.add(-2.0);
      list.add(5.0);
      System.out.println(list);
      Polynomial p = new Polynomial(list);
      list=p.integrate();
      System.out.println(list);
      System.out.println(p);
   }
   
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
   
   public List<Double> differentiate()
   {
      for(int ii = 0; ii < coefficients.size(); ii++)
      {
         coefficients.set(ii, coefficients.get(ii) * ii);
      }
      coefficients.remove(0);
      return coefficients;     
   }
   
   public List<Double> integrate()
   {
      for(int ii = 0; ii < coefficients.size(); ii++)
      {
         coefficients.set(ii, round(coefficients.get(ii) / (ii + 1)));
      }
      coefficients.add(0, null);
      return coefficients;
   }
   
   private double round(double number)
   {
      double rounded=(double) Math.round(number*1000)/1000;
      return rounded;
   }
}