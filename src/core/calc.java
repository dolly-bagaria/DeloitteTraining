package core;

public class calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate(5,0,"/");
	}
	public static void calculate(double a, double b, String op)
	{
		double result=0;
		switch(op)
		{
		case "+": result=a+b;
				  break;
		case "-": result=a-b;
		  		  break;
		case "*": result=a*b;
		  		  break;
		case "/": if(b!=0)
					result=a+b;
				  else {
					  System.out.println("divide by zero error");
					  return;
				  }
		  		  break;
		default: System.out.println("invalid operator");
		}
		System.out.println("result: "+ result);
	}

}
