package com.deloitte.calculator;
import java.util.*;


public class CalculatorTask
{
static int flag=0;
static int flag_error=0;
//main method to get inputs
public static void main(String[] args) throws InvalidOperatorException
{
CalculatorTask ct=new CalculatorTask();
Scanner sc=new Scanner(System.in);
System.out.println("============[ Simple Arithmetic Calculator ] =============");
System.out.println("Please enter 1st number: ");
String num1=sc.next();
System.out.println("Please enter 2nd number: ");
String num2=sc.next();
System.out.println("Please select the operation you wan to perform [+,-,*,/,&,=] :");
String operator=sc.next();
validateNumber(num1,num2);
validateoperator(operator);
if(ct.flag==1)
{
calculate(num1,num2,operator);
}
}
//calculate method to calculate the result
private static void calculate(String number1, String number2, String operator)
{
float num1=Float.parseFloat(number1);
float num2=Float.parseFloat(number2);
float result=0;
if(operator.equals("="))
{
if (num1<num2)
{
operator="<";
}
else if(num1>num2)
{
operator=">";
}
else
{
operator="==";
}
System.out.println("Result : "+num1+" "+operator+" "+num2);
}
else if(operator.equals("/"))
{
if(num2==0)
{
System.out.println("[Your input has error, please correct]\nDivision by Zero is not possible.");
}
else
{
result=num1/num2;
System.out.println("Result : "+num1+" "+operator+" "+num2+" = "+result);
}
}
else if(operator.equals("&"))
{
result=(int)num1&(int)num2;
System.out.println("Result : "+(int)num1+" "+operator+" "+(int)num2+" = "+(int)result);
}
else
{
if(operator.equals("+"))
{
result=num1+num2;
}
else if(operator.equals("-"))
{
result=num1-num2;
}
else if(operator.equals("*"))
{
result=num1*num2;
}
System.out.println("Result : "+num1+" "+operator+" "+num2+" = "+result);
}
}
//method for validating the operator
private static void validateoperator(String operator) throws InvalidOperatorException
{
try
{
if ((operator.equals("+"))||(operator.equals("-"))||(operator.equals("*"))||(operator.equals("/"))||(operator.equals("&"))||(operator.equals("=")))
{
flag=1;
}
else
{
flag=0;
throw new InvalidOperatorException();
}
}
catch(InvalidOperatorException e)
{
if(flag_error!=1)
{
flag_error=1;
System.out.println("[your input has error, please correct]");
}
System.out.println("InvalidOperator : Operator- Please select valid operator");
}
}
//method for validating the input numbers
public static void validateNumber(String number1,String number2)
{
try
{
float Number1=Float.parseFloat(number1);
flag=1;
}
catch(Exception e)
{
flag=0;
if(flag_error!=1)
{
flag_error=1;
System.out.println("[your input has error, please correct]");
}
System.out.println("NumberFormatException : 1 st number - Please enter numeric only");
}
try
{
float Number2=Float.parseFloat(number2);
flag=1;
}
catch(Exception e)
{
flag=0;
if(flag_error!=1)
{
flag_error=1;
System.out.println("[your input has error, please correct]");
}
System.out.println("NumberFormatException : 2 nd number - Please enter numeric only");
}
}
}
