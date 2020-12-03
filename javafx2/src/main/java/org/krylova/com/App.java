package org.krylova.com;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        Application.launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello");

        Button button = new Button("BTN");
        Group group = new Group(button);

        FlowPane root = new FlowPane(group);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
