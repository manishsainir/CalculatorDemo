package application.controller;

import application.model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

	@FXML
	private TextField textField;

	private static boolean action = false;
	private static String op;
	private static Double num;
	private static int flag = 0;

	public void start(ActionEvent event) {
		action = true;
		textField.setText("0");
		num = 0d;
	}

	public void stop(ActionEvent event) {
		if (action == true) {
			action = false;
			textField.setText(null);
		}
	}

	public void processNumber(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		if (action) {
			if (value.equals("C")) {
				textField.setText("0");
			} else {
				if (flag == 1) {
					textField.setText(value);
					flag = 0;
				} else {
					if (textField.getText().equals("0") && !value.equals(".")) {
						textField.setText(value);

					} else {
						textField.setText(textField.getText() + value);

					}
				}
			}
		}
	}

	public void processOperator(ActionEvent event) {
		if (action) {
			String value = ((Button) event.getSource()).getText();
			if (value.equals("=")) {
				flag = 1;
				double result = CalculatorModel.calculate(num, Double.parseDouble(textField.getText()), op);
				String text = Double.toString(Math.abs(result));
				int integerPlaces = text.indexOf('.');
				int decimalPlaces = text.length() - integerPlaces - 1;

				if ((decimalPlaces == 1 && text.charAt(integerPlaces + 1) == '0') || decimalPlaces == 0) {
					textField.setText(String.valueOf((long) result));

				} else {
					textField.setText(String.valueOf(result));
				}

			} else {
				num = Double.parseDouble(textField.getText());
				op = value;
				textField.setText("0");

			}
		}
	}

}
