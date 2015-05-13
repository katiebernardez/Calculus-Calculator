public class Trigonometric extends Equation
{
   private String function;
   private double coeff;
   private Equation inside;
   private String SIN;
   private String COS;
   private String TAN;
   private String CSC;
   private String SEC;
   private String COT;
   private String SIN_DERIV;
   private String COS_DERIV;
   private String TAN_DERIV;
   private String CSC_DERIV;
   private String SEC_DERIV;
   private String COT_DERIV;
   private String SIN_INT;
   private String COS_INT;
   private String TAN_INT;
   private String CSC_INT;
   private String SEC_INT;
   private String COT_INT;

   public Trigonometric(String function, double coeff, Equation inside)
   {
      this.function=function.toLowerCase();
      this.coeff=coeff;
      this.inside=inside;
      SIN="sin("+inside.toString()+")";
      COS="cos("+inside.toString()+")";
      TAN="tan("+inside.toString()+")";
      CSC="csc("+inside.toString()+")";
      SEC="sec("+inside.toString()+")";
      COT="cot("+inside.toString()+")";
      SIN_DERIV=COS;
      COS_DERIV="-"+SIN;
      TAN_DERIV="sec^2("+inside.toString()+")";
      CSC_DERIV="-"+COT+CSC;
      SEC_DERIV=TAN+SEC;
      COT_DERIV="-csc^2("+inside.toString()+")";
      SIN_INT="-"+COS;
      COS_INT=SIN;
      TAN_INT="-ln("+COS+")";
      CSC_INT="-ln("+COT+"+"+CSC+")";
      SEC_INT="ln("+TAN+"+"+SEC+")";
      COT_INT="ln("+SIN+")";
   }
   
   public String differentiate()
   {
      if(function.equals("sin"))
         return coeff+"*"+SIN_DERIV+"*("+inside.differentiate()+")";
      else if(function.equals("cos"))
         return coeff+"*"+COS_DERIV+"*("+inside.differentiate()+")";
      else if(function.equals("tan"))
         return coeff+"*"+TAN_DERIV+"*("+inside.differentiate()+")";
      else if(function.equals("csc"))
         return coeff+"*"+CSC_DERIV+"*("+inside.differentiate()+")";
      else if(function.equals("sec"))
         return coeff+"*"+SEC_DERIV+"*("+inside.differentiate()+")";
      else //if(function.equals("cot"))
         return coeff+"*"+COT_DERIV+"*("+inside.differentiate()+")";
   }
   
   public String integrate()
   {
      if(function.equals("sin"))
         return "("+coeff+"*"+SIN_INT+")/("+inside.differentiate()+") +C";
      else if(function.equals("cos"))
         return "("+coeff+"*"+COS_INT+")/("+inside.differentiate()+") +C";
      else if(function.equals("tan"))
         return "("+coeff+"*"+TAN_INT+")/("+inside.differentiate()+") +C";
      else if(function.equals("csc"))
         return "("+coeff+"*"+CSC_INT+")/("+inside.differentiate()+") +C";
      else if(function.equals("sec"))
         return "("+coeff+"*"+SEC_INT+")/("+inside.differentiate()+") +C";
      else //if(function.equals("cot"))
         return "("+coeff+"*"+COT_INT+")/("+inside.differentiate()+") +C";
   }
   
   public String toString()
   {
      if(function.equals("sin"))
         return coeff+SIN;
      else if(function.equals("cos"))
         return coeff+COS;
      else if(function.equals("tan"))
         return coeff+TAN;
      else if(function.equals("csc"))
         return coeff+CSC;
      else if(function.equals("sec"))
         return coeff+SEC;
      else //if(function.equals("cot"))
         return coeff+COT;
   }
}