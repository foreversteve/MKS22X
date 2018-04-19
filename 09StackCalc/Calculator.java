import java.util.LinkedList;

public class Calculator {

	 static LinkedList<Double> stack;
	 static final String[] operators = {"+","-","*","/","%"};

	 public static boolean check(String s) {
		 for (String x : operators) {
			 if (x.equals(s)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 public static double eval(String s){
		 stack = new LinkedList<>();

		 String[] list = s.split(" ");

		 for (int i = 0; i < list.length; i++) {
			 if(list[i].equals("+")) {
				 double a = stack.pop();
				 double b = stack.pop();
				 double sum = a+b;
				 stack.push(sum);
			 }
			 else if (list[i].equals("-")) {
				 double b = stack.pop();
				 double a = stack.pop();
				 double difference = a-b;
				 stack.push(difference);
			 }
			 else if (list[i].equals("*")) {
				 double a = stack.pop();
				 double b = stack.pop();
				 double product = a * b;
				 stack.push(product);
			 }
			 else if (list[i].equals("/")) {
				 double b = stack.pop();
				 double a = stack.pop();
				 double quotient = a / b;
				 stack.push(quotient);
			 }
			 else if (list[i].equals("%")) {
				 double b = stack.pop();
				 double a = stack.pop();
				 double modulo = a % b;
				 stack.push(modulo);
			 }
			 else {
				 //System.out.println(list[i]);
				 stack.push(Double.parseDouble(list[i]));
			 }
		 }

		 return stack.getFirst();
	 }

	 public static void main(String[] args) {
		 System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
		 System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
		 System.out.println(Calculator.eval("10 2.0 +"));


	 }
}
