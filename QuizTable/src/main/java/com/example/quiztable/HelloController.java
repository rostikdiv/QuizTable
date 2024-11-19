package com.example.quiztable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    //checkBox

    @FXML
    private CheckBox answComplexity;

    @FXML
    private CheckBox answConsensus;

    @FXML
    private CheckBox answFlexibility;

    @FXML
    private CheckBox answFriendship;

    @FXML
    private Label answerInCheckBox;

    @FXML
    private Button btnGetAnswerToCheckBox;
    ArrayList<CheckBox> listOfAnswer= new ArrayList<>();
    //ChoiceBox
    @FXML
    private Button btnGetAnswerToChoiceBox;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label answerInChoiceBox;
    //ComboBox
    @FXML
    private Label answerInComboBox;
    @FXML
    private ComboBox<String> comboBox;
    //RadioButton
    @FXML
    private RadioButton RBtnProperties;
    @FXML
    private RadioButton RBtnLayout;
    @FXML
    private RadioButton RBtnCode;
    @FXML
    private RadioButton RBtnHierarchy;
    @FXML
    private Label answerInRadioButton;

    private ToggleGroup radioToggleGroup;



    @FXML
    void getAnswerToCheckBox(ActionEvent event) {
        String wariants="";
        if (answConsensus.isSelected()) {
            wariants += "погодженість, ";
            listOfAnswer.add(answConsensus);
        }
        if (answFriendship.isSelected()) {
            wariants += "гнучкість, ";
            listOfAnswer.add(answFlexibility);
        }
        if (answFlexibility.isSelected()) {
            wariants += "дружність, ";
            listOfAnswer.add(answFriendship);
        }
        if (answComplexity.isSelected()) {
            wariants += "складність, ";
            listOfAnswer.add(answComplexity);
        }


        editAnswer(listOfAnswer, answerInCheckBox,wariants);
    }

    void editAnswer(ArrayList<CheckBox> listOfAnswer, Label label, String wariants){
        if ((listOfAnswer.isEmpty()
        )){
            label.setText("Ви не вказади вашу відповідь: ");

        } else if (listOfAnswer.size() == 3&& listOfAnswer.contains(answConsensus)&& listOfAnswer.contains(answFlexibility)&& listOfAnswer.contains(answFriendship)){
            label.setText("Ваша відповіь: "+wariants+"є правильною.");
        } else{
            label.setText("Ваша відповіь: "+wariants+"не є правильною.");
        }
        answComplexity.setSelected(true);
        listOfAnswer.clear();
    }

    @FXML
    void getAnswerToChoiceBox(ActionEvent event) {

        try{
            String answer = choiceBox.getValue().toString();

            if (answer.equals("Правильно"))
                answerInChoiceBox.setText("Відповідь: ви надали правильну відповідь.");
            else if (answer.equals("Неправильно"))
                answerInChoiceBox.setText("Відповідь: ви надали не правильну відповідь подумайте ще раз.");
        } catch (NullPointerException e){
            answerInChoiceBox.setText("Відповідь: ви не вказал варіант відповіді.");
        }

    }

    @FXML
    void getAnswerInComboBox(ActionEvent event) {

        if (comboBox.getValue().equals("BorderPane")){
            answerInComboBox.setText("Відповідь: "+ comboBox.getValue()+" правильна");

        } else {
            answerInComboBox.setText("Відповідь: "+ comboBox.getValue()+" не правильна");

        }
    }

    @FXML
    void getAnswerInRadioButton(ActionEvent event) {
        if (this.radioToggleGroup.getSelectedToggle().equals(this.RBtnCode)){
            answerInRadioButton.setText("Відповідь: Code не є правилною");
        }

        if (this.radioToggleGroup.getSelectedToggle().equals(this.RBtnHierarchy)){
            answerInRadioButton.setText("Відповідь: Hierarchy не є правилною");
        }

        if (this.radioToggleGroup.getSelectedToggle().equals(this.RBtnLayout)){
            answerInRadioButton.setText("Відповідь: Layout не є правилною");
        }

        if (this.radioToggleGroup.getSelectedToggle().equals(this.RBtnProperties)){
            answerInRadioButton.setText("Відповідь: Properties є правильною");
        }


    }

    @FXML
    void menuClearAll(ActionEvent event) {
        answConsensus.setSelected(false);
        answFriendship.setSelected(false);
        answFlexibility.setSelected(false);
        answComplexity.setSelected(false);

    }

    @FXML
    void menuClearFirsHalf(ActionEvent event) {
        answConsensus.setSelected(false);
        answFriendship.setSelected(false);

    }

    @FXML
    void menuClearSecondHalf(ActionEvent event) {
        answFlexibility.setSelected(false);
        answComplexity.setSelected(false);

    }

    @FXML
    void getHelp(ActionEvent event) {
        answerInCheckBox.setText("для того щоб вибрати відповідь нажміть на квадратик один або декілька");
    }

    @FXML
    void initialize() {
        assert answerInRadioButton != null : "fx:id=\"answerInRadioButton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnGetAnswerToCheckBox != null : "fx:id=\"btnGetAnswerToCheckBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnGetAnswerToChoiceBox != null : "fx:id=\"btnGetAnswerToChoiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnProperties != null : "fx:id=\"RBtnProperties\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answComplexity != null : "fx:id=\"answComplexity\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInChoiceBox != null : "fx:id=\"answerInChoiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnCode != null : "fx:id=\"RBtnCode\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnHierarchy != null : "fx:id=\"RBtnHierarchy\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInCheckBox != null : "fx:id=\"answerInCheckBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert RBtnLayout != null : "fx:id=\"RBtnLayout\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answConsensus != null : "fx:id=\"answConsensus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answFriendship != null : "fx:id=\"answFriendship\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answerInComboBox != null : "fx:id=\"answerInComboBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answFlexibility != null : "fx:id=\"answFlexibility\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'hello-view.fxml'.";


        answerInCheckBox.setText("");
        answerInChoiceBox.setText("");

        choiceBox.getItems().addAll("Правильно", "Неправильно");

        answerInComboBox.setText("");
        comboBox.getItems().addAll("BorderPane","AncorePane","HBox");

        answerInRadioButton.setText("");
        radioToggleGroup = new ToggleGroup();
        this.RBtnProperties.setToggleGroup(radioToggleGroup);
        this.RBtnLayout.setToggleGroup(radioToggleGroup);
        this.RBtnCode.setToggleGroup(radioToggleGroup);
        this.RBtnHierarchy.setToggleGroup(radioToggleGroup);

    }

}
