package converter.comshrooti;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Convertor");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File"
        );
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New evnt clicked"));
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> Platform.exit());
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMenuItem=new MenuItem("About");
        aboutMenuItem.setOnAction(event -> aboutApp());
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        helpMenu.getItems().addAll(aboutMenuItem);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertdialogue=new Alert(Alert.AlertType.INFORMATION);
        alertdialogue.setTitle("My first Desktop App");
        alertdialogue.setHeaderText("Just a trial");
        alertdialogue.setContentText("I am just a beginner but soon will be pro and start developing awesome Java Games," +
                "and applications.This job is interesting,and I'm really enjoying my work\n"+"This is all about learning and learning" +
                "more and more.\nReally a fun task and can't wait for further explorations in the field.\n"+"At the end can conclude" +
                "that yes Java is my love and passion...something I enjoy while doing.\n"+"Thanks for spending your time in reading this\n"
                +"\n"+"                                                                                         Created by Shrooti");
        ButtonType yesButton=new ButtonType("Yay");
        ButtonType noButton=new ButtonType("Nah");
        alertdialogue.getButtonTypes().setAll(yesButton,noButton);
        alertdialogue.showAndWait();
        Optional<ButtonType> clickedButton=alertdialogue.showAndWait();
        if(clickedButton.isPresent() && clickedButton.get()==yesButton)
        {
            System.out.println("Clicked");
        }
        else
        {
            System.out.println("Not Clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}