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
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import liststacktemplate.MyStack;

public class PostfixCalculator extends Application {

    

    public static void main(String[] args) {
        launch(args);

        // TODO code application logic here
    }
    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        stage.setTitle("test");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
