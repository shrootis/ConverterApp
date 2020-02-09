package converter.comshrooti;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox1;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;
    private static final String cTf="Celsius to Farenheit";
    private static final  String fTc="Farenheit to Celsius";
    private  boolean isCtF=true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox1.getItems().add(cTf);
        choiceBox1.getItems().add(fTc);
        choiceBox1.setValue(cTf);
        choiceBox1.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
            if(newValue.equals(cTf))
            {
                isCtF=true;
                System.out.println(cTf);
            }
            else {
                isCtF=false;
                System.out.println(fTc);
            }

        });
        convertButton.setOnAction(event ->
        {
            convert();
        });
    }

    private void convert() {
        String input= userInputField.getText();
        float enteredTem;
        enteredTem = 0.0f;
        try {
            enteredTem = Float.parseFloat(input);

        }
        catch (Exception exception){
            warnUser();
            return;
        }

        float newT=0.0f;
        if(isCtF)
        {
            newT=(enteredTem*9/5)+32;
        }else
        {
            newT=(enteredTem-32)*5/9;
        }
        display(newT);
    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Entry");
        alert.setContentText("Enter valid input");
        alert.show();
    }

    private void display(float newT) {
        String unit=isCtF?"F":"C";
        System.out.println("The new temperature is: "+newT+unit);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: "+newT+unit);
        alert.show();
    }
}
