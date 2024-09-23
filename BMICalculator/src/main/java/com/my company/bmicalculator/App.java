// Christina Grant - 9/23/2024 BMI Calculator

package com.mycompany.bmicalculator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
    // components in the form
    Text text1 = new Text("Weight(lb/kg)");   
    Text text2 = new Text("Height(in/m)");
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();   
    Button button1 = new Button("Calculate");
    Label label1 =new Label("Result of BMI :");
    Label label2=new Label("answer");

   // add BMI VALUES
    Label label3 = new Label("BMI VALUES");
    Label label4 = new Label("Underweight: less than 18.5");
    Label label5 = new Label("Normal: between 18.5 and 24.9");
    Label label6 = new Label("Overweight: between 25 and 29.9");
    Label label7 = new Label("Obese: 30 or greater");
  
    final ComboBox combobox1 = new ComboBox();
    combobox1.getItems().addAll("lb", "kg");

    final ComboBox combobox2 = new ComboBox();
    combobox2.getItems().addAll("in", "m");

    GridPane gridPane = new GridPane();
    
    // make size of screen */
    gridPane.setMinSize(500, 300);

    // set padding value
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    // vertical and horizontal spaces between fields */
    gridPane.setVgap(10);
    gridPane.setHgap(10);   

    // set Grid alignment
    gridPane.setAlignment(Pos.CENTER);
    
    // put fields in different positions */
    gridPane.add(text1, 0, 0);
    gridPane.add(textField1, 1, 0);
    gridPane.add(text2, 0, 1);   
    gridPane.add(textField2, 1, 1);
    gridPane.add(button1, 0, 2);
    gridPane.add(label1, 0, 3);
    gridPane.add(label2, 1, 3);
    gridPane.add(combobox1, 2, 0);
    gridPane.add(combobox2, 2, 1);   

    // add BMI VALUES
    gridPane.add(label3, 0, 5);
    gridPane.add(label4, 0, 6);
    gridPane.add(label5, 0, 7);
    gridPane.add(label6, 0, 8);
    gridPane.add(label7, 0, 9);

    // style nodes
    button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

    text1.setStyle("-fx-font: normal bold 20px 'serif' ");
    text2.setStyle("-fx-font: normal bold 20px 'serif' ");
    label3.setStyle("-fx-font: normal bold 20px 'serif' ");
    gridPane.setStyle("-fx-background-color: WHITE;");

    // button action event
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e)
    {
               // declare variables/
               double wt,ht,bmi;
               
               // put boxes in text fields
               wt=Double.valueOf(textField1.getText());
               ht=Double.valueOf(textField2.getText());
               if (combobox1.getValue() == "lb" && combobox2.getValue() == "in")
               {  
               // calculate the value*/
               bmi=(wt*703)/(ht*ht);
               
               // result is printed to label2
               label2.setText(Double.toString(bmi)+ " lb/in ");
               }
              
               if (combobox1.getValue() == "kg" && combobox2.getValue() == "m")
               {  
               // calculate the value
               bmi=(wt/(ht*ht));
               
               // result is printed to label2
               label2.setText(Double.toString(bmi)+ " kg/m");
               }
    }
};
  
    // when button is pressed
    button1.setOnAction(event);
    
    // create a scene object
    Scene sc = new Scene(gridPane);
    
    // put in a title
    stage.setTitle("BMI Calculator");
    
    // add scene to stage
    stage.setScene(sc);
    
    // display the contents of the stage
    stage.show();
    }
    
    public static void main(String args[]){
        launch(args);
    }
}
