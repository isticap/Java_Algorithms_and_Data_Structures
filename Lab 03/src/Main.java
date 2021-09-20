public class Main {
	
	static long [] memory = new long[93];
	
	public static void main(String [] args) {
		memory[1] = 1;
		for (int i = 0; i < 93; i++)
			System.out.printf("Fib(%d) = %d\n", i, fib(i));
	}
	
	public static long fib(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			if (memory[n] == 0)
				memory[n] = fib(n-1) + fib(n-2);
			return memory[n];
		}
	}
	
	public static long notRecursiveFib(int n) {
		long f1 = 0;
		long f2 = 1;
		for (int i = 0; i < n; i++) {
			f2 = f1 + (f1 = f2);
		}
		return f1;
	}
}