package interview.questions;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calculator = (a, b) -> a * b + 1;

		System.out.println(calculator.sum(5, 7));

	}

}
