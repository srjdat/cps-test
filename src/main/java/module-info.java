module com.example.cpstest {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
                
    opens com.example.cpstest to javafx.fxml;
    exports com.example.cpstest;
}