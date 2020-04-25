package application.model;

public class CalculatorModel {

	public static double calculate(double num1, double num2, String op) {

		switch (op) {
		case "+":
			return (num1 + num2);
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return (double) 0;
		}

	}

}
