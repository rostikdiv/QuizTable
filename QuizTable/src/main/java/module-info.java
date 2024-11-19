module com.example.quiztable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quiztable to javafx.fxml;
    exports com.example.quiztable;
}