package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Controller {

    private Text done_txt;
    private Text java_txt;
    private Text fx_txt;
    private Text example;
    private TextArea yourText;

    private Set<String> fonts = new HashSet<>();

    private Iterator<String> it = fonts.iterator();

    public Controller(Text done, Text java, Text fx, Text ex, TextArea yours) {
        done_txt=done;
        java_txt=java;
        fx_txt=fx;
        fx_txt.setOnMouseClicked((e) -> changeFx());
        example=ex;
        yourText=yours;

        fonts.add("../fonts/bb.otf");
        fonts.add("../fonts/fo.otf");
        fonts.add("../fonts/comic.ttf");
        fonts.add("../fonts/hobbit.ttf");
        fonts.add("../fonts/nasa.ttf");
        fonts.add("../fonts/sc.ttf");
        fonts.add("../fonts/star.ttf");
        yourText.requestFocus();
    }

    public void changeFx() {
        if (!it.hasNext()) {
            it = fonts.iterator();
        }
        String font = it.next();
        Font bf = Font.loadFont(getClass().getResource(font).toExternalForm(), 50),
                sf = Font.loadFont(getClass().getResource(font).toExternalForm(), 30);
        done_txt.setFont(bf);
        java_txt.setFont(bf);
        fx_txt.setFont(bf);

        example.setFont(sf);
        yourText.setFont(sf);
        yourText.requestFocus();
    }
}