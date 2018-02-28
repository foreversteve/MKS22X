public class Recursion {

	public int fact(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n < 1) {
			return 1;
		}
		return fact(n-1)*n;
	}

	public int fibhelp(int count, int end,int num1, int num2) {
		if (count == end ) {
			return num1;
		}

		return fibhelp(count+1,end,num2,num1+num2);
	}

	public int fib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		return fibhelp(0,n,0,1);
	}

	public double abs(double n) {
		if (n < 0) {
			return -n;
		}
		return n;
	}
	public double sqrthelp(double n, double guess) {

		if (abs(guess*guess - n) <= n * 0.00001) {
			return guess;
		}
		return sqrthelp(n, (n / guess + guess) / 2);
	}
	public double sqrt(double n) {
		if (n < 0){
	    throw new IllegalArgumentException();
		}
		return sqrthelp(n,n/2);
	}
	public static void main(String[] args) {
		Recursion a = new Recursion();
		System.out.println(a.fact(5));
		System.out.println(a.fib(5));
		double[] list = {1,2,4,9,16,25,36,49,64,81,100};
		for (double i : list) {
			System.out.println(a.sqrt(i)+"  "+i);
		}
	}

}
