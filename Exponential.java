import java.util.*;

public class Exponential extends Equation
{
   private double coefficient;
   private double base;
   private Equation inside;
   private String type;
   
   public Exponential(double coefficient, double base, Equation inside, String type)
   {
      this.coefficient = coefficient;
      this.base = base;
      this.inside = inside;
      this.type = type;
   }
   
   public String toString()
   {
      String equation = "";
      if(type.equals("exponential")) {
         equation = coefficient + "*" + base + "^(" + inside + ")";
      } else {
         equation = coefficient + "*log(" + base + ")( " + inside + ")"; }
      return equation;
   }
   
   public String differentiate()
   {
      String equation = "";
      if(type.equals("exponential")) {
         equation = this.toString() + "*ln(" + base + ")*(" + inside.differentiate() + ")";
      } else {
         equation = "(" + coefficient + "/(" + inside + "*ln(" + base + "))*(" + inside.differentiate() + ")"; }
      return equation;
   }
   
   public String integrate()
   {
      String equation = "";
      if(type.equals("exponential")) {
         equation = "(" + this.toString() + ")/(" + inside.differentiate() + "*ln(" + base + ")) + C";
      } else {
         equation = "(" + coefficient + "*(" + inside + ")*ln(" + inside + ") - " + coefficient + "*(" + inside + "))/(" + inside.differentiate() + "*ln(" + base + ")) + C"; }
      return equation;
   }
}