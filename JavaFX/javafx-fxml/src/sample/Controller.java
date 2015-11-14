package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.omg.CORBA.INITIALIZE;

import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable {

    @FXML
    private Text txt;
    @FXML
    private Text fx;
    @FXML
    private Text ml;

    @FXML
    private Text example;
    @FXML
    private TextArea yourText;

    private Set<String> fonts = new HashSet<>();

    private Iterator<String> it = fonts.iterator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fonts.add("../fonts/bb.otf");
        fonts.add("../fonts/fo.otf");
        fonts.add("../fonts/comic.ttf");
        fonts.add("../fonts/hobbit.ttf");
        fonts.add("../fonts/nasa.ttf");
        fonts.add("../fonts/sc.ttf");
        fonts.add("../fonts/star.ttf");
        txt.setText(txt.getText()+" ");
        yourText.requestFocus();
    }

    @FXML
    public void changeFx(){
        if (!it.hasNext()) {
            it = fonts.iterator();
        }
        String font = it.next();
        Font bf = Font.loadFont(getClass().getResource(font).toExternalForm(), 50),
                sf = Font.loadFont(getClass().getResource(font).toExternalForm(), 30);
        txt.setFont(bf);
        fx.setFont(bf);
        ml.setFont(bf);
        example.setFont(sf);
        yourText.setFont(sf);
        yourText.requestFocus();
    }
}
