module projectfiles.currencyinfo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.xml;

    opens projectfiles.currencyinfo to javafx.fxml;
    exports projectfiles.currencyinfo;
}