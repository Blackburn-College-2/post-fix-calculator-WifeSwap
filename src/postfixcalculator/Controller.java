/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixcalculator;

/**
 *
 * @author Gabl
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import liststacktemplate.MyStack;

public class Controller {

    MyStack stack = new MyStack();
    String inputedText = "";
    @FXML
    private Button btnCalculate;

    @FXML
    private TextField textFieldCalculator;

    @FXML
    private Text txtAnswer;

    @FXML
    void calculate(MouseEvent event) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
        inputedText = textFieldCalculator.getText();
        while (inputedText.length() > 0) {
            int i = inputedText.length() - 1;
            String partialString = "";
            //System.out.println(inputedText);
            if (inputedText.charAt(i) == ' ') {
                inputedText = inputedText.substring(0, i);
                //System.out.println("removed space");
                //System.out.println(inputedText);
                i--;
            }
            while (i >= 0 && inputedText.charAt(i) != ' ') {
                partialString = inputedText.charAt(i) + partialString;
                i--;
                //System.out.println(i);

            }
            stack.push(partialString);
            //System.out.println("partial string is: " + partialString);
            //System.out.println("removing characters");
            inputedText = inputedText.substring(0, i + 1);
        }
        System.out.println(stack);
        double num1 = 0;
        double num2 = 0;
        while (!stack.isEmpty()) {
            if (stack.size()>2){
            num1 = Double.parseDouble(String.valueOf(stack.pop()));
            num2 = Double.parseDouble(String.valueOf(stack.pop()));
            stack.push(doMath(num1, num2));
                System.out.println(stack);
            }else{
            num1 = Double.parseDouble(String.valueOf(stack.pop()));
            txtAnswer.setText(String.valueOf(num1));                
            }
        }
    }

    public double doMath(double num1, double num2) {
        double answer = 0;
        if (((String) stack.peek()).charAt(0) == '+') {
            stack.pop();
            answer = num1 + num2;
        } else if (((String) stack.peek()).charAt(0) == '-') {
            stack.pop();
            answer = num1 - num2;
        } else if (((String) stack.peek()).charAt(0) == '/') {
            stack.pop();
            answer = num1 / num2;
        } else if (((String) stack.peek()).charAt(0) == '*') {
            stack.pop();
            answer = num1 * num2;
        }
        return answer;
    }

    public boolean checkForSymbol(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '*' || s.charAt(0) == '/') {
                return true;
            }
        }
        return false;

    }
}
