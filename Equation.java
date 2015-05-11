public abstract class Equation
{
   protected String equation;
   
   public Equation(String equation)
   {
      this.equation = equation;   
   }
   
   abstract void translate();
   
   abstract String differentiate();
   
   abstract String integrate();
   
}