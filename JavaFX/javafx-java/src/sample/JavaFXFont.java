package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// Huchede Thomas
// JavaFx in Java

public class JavaFXFont extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("JavaFX Font Demo");

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50, 80, 50, 80));

        Text done_txt = new Text("Done in ");
        done_txt.getStyleClass().add("basic-font");

        Text java_txt = new Text("Java");
        java_txt.getStyleClass().add("basic-font");

        List<Stop> java_stops = new ArrayList<>();
        java_stops.add(new Stop(0,Color.RED));
        java_stops.add(new Stop(1,Color.DARKRED));

        done_txt.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, java_stops));
        java_txt.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, java_stops));

        Text fx_txt = new Text("FX");
        fx_txt.getStyleClass().add("basic-font");

        List<Stop> fx_stops = new ArrayList<>();
        fx_stops.add(new Stop(0,Color.WHITE));
        fx_stops.add(new Stop(1,Color.DARKGRAY));

        fx_txt.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, fx_stops));

        Effect fx_effect = new DropShadow(BlurType.GAUSSIAN, Color.DARKGRAY, 15.0, 0.25, 0, 0);
        fx_txt.setEffect(fx_effect);

        Text use = new Text("Click on the \"fx\" to switch font, then type anything you want !");
        use.getStyleClass().add("basic-very-small-font");
        use.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, fx_stops));
        use.setEffect(fx_effect);

        Text example = new Text("The quick brown fox jumps overs the lazy dog");
        example.getStyleClass().add("basic-small-font");

        TextArea yourText = new TextArea();

        hbox.getChildren().addAll(done_txt, java_txt, fx_txt);
        root.getChildren().addAll(hbox, use, example, yourText);

        Scene scene = new Scene(root);

        Background bg = new Background(new BackgroundFill(Color.rgb(38,38,38), null, null));
        root.setBackground(bg);

        root.getStylesheets().add(getClass().getResource("style.css").toString());


        Controller cc = new Controller(done_txt, java_txt, fx_txt, example, yourText);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
