package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label instructions = new Label("Enter your birthday: (MM/DD): ");
        instructions.setFont(new Font(18));

        TextField input = new TextField();
        input.setPromptText("MMDD");

        // auto add slash
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            String digits = newValue.replaceAll("[^\\d]", "");

            if (digits.length() > 4) {
                digits = digits.substring(0, 4);
            }

            if (digits.length() >= 3) {
                digits = digits.substring(0, 2) + "/" + digits.substring(2);
            }

            if (!newValue.equals(digits)) {
                input.setText(digits);
            }
        });

        Button button = new Button("Find Zodiac");
        button.setFont(new Font(16));

        button.setOnAction(e -> {
            String birthday = input.getText();
            String zodiac = getZodiac(birthday);
            showResultWindow(birthday, zodiac);
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(instructions, input, button);

        Scene scene = new Scene(layout, 350, 200);

        primaryStage.setTitle("Zodiac Input");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showResultWindow(String birthday, String zodiac) {
        Stage resultStage = new Stage();

        Label birthdayLabel = new Label("Birthday Entered: " + birthday);
        birthdayLabel.setFont(new Font(20));

        Label zodiacLabel = new Label(zodiac);
        zodiacLabel.setFont(new Font(32));

        VBox resultLayout = new VBox(20);
        resultLayout.setAlignment(Pos.CENTER);
        resultLayout.getChildren().addAll(birthdayLabel, zodiacLabel);

        Scene resultScene = new Scene(resultLayout, 450, 250);

        resultStage.setTitle("Zodiac Finder");
        resultStage.setScene(resultScene);
        resultStage.show();
    }

    private String getZodiac(String date) {
        if (date.compareTo("03/21") >= 0 && date.compareTo("04/19") <= 0)
            return "♈ Aries";
        else if (date.compareTo("04/20") >= 0 && date.compareTo("05/20") <= 0)
            return "♉ Taurus";
        else if (date.compareTo("05/21") >= 0 && date.compareTo("06/20") <= 0)
            return "♊ Gemini";
        else if (date.compareTo("06/21") >= 0 && date.compareTo("07/22") <= 0)
            return "♋ Cancer";
        else if (date.compareTo("07/23") >= 0 && date.compareTo("08/22") <= 0)
            return "♌ Leo";
        else if (date.compareTo("08/23") >= 0 && date.compareTo("09/22") <= 0)
            return "♍ Virgo";
        else if (date.compareTo("09/23") >= 0 && date.compareTo("10/22") <= 0)
            return "♎ Libra";
        else if (date.compareTo("10/23") >= 0 && date.compareTo("11/21") <= 0)
            return "♏ Scorpio";
        else if (date.compareTo("11/22") >= 0 && date.compareTo("12/21") <= 0)
            return "♐ Sagittarius";
        else if (date.compareTo("12/22") >= 0 || date.compareTo("01/19") <= 0)
            return "♑ Capricorn";
        else if (date.compareTo("01/20") >= 0 && date.compareTo("02/18") <= 0)
            return "♒ Aquarius";
        else if (date.compareTo("02/19") >= 0 && date.compareTo("03/20") <= 0)
            return "♓ Pisces";
        else
            return "Invalid date";
    }

    public static void main(String[] args) {
        launch(args);
    }
}