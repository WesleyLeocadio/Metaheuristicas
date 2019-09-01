package controle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControladorPrincipal implements Initializable {

    @FXML
    private Button btInicio, btGenetico, btPso, btResultado;

    @FXML
    private BorderPane borderPrincipal;

    @FXML
    private AnchorPane anchorInicial;

    @FXML
    private Label labelTroca;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    private void inicio() {
        borderPrincipal.setCenter(anchorInicial);

    }

    @FXML
    private void testeGenetico() {
        try {
            Parent genetico =  FXMLLoader.load(getClass().getResource("../telas/genetico.fxml"));
            borderPrincipal.setCenter(genetico);
            labelTroca.setText("Algoritimo Genético");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void testePso() {
        try {
            Parent genetico =  FXMLLoader.load(getClass().getResource("../telas/pso.fxml"));
            borderPrincipal.setCenter(genetico);
            labelTroca.setText("PSO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sair(){
        System.exit(0);
    }

}
