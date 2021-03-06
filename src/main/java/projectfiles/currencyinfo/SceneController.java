package projectfiles.currencyinfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToViewCurrency(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewCurrency.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToCalculate(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewCalculation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToGraph(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewGraph.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
