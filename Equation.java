import java.util.*;

public abstract class Equation
{   
   public Equation()
   {
   
   }
   
   //abstract String toString();
   
   abstract List<Double> differentiate();
   
   abstract List<Double> integrate();
   
}