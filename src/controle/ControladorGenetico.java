package controle;

import ag.Genetico;
import ag.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Time;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorGenetico implements Initializable {

    @FXML
    private Button btnItens, btDadosItens, btnGerar;

    @FXML
    private TextField qtdItens, valorItem, pesoItem, capacidadeMochila;

    @FXML
    private Label labelCont;

    int cont = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    private void limparTextFild(){
        valorItem.clear();
        pesoItem.clear();
    }

    @FXML
    public void informarQuantidade(){

        int quantidade = Integer.parseInt(qtdItens.getText());
        Principal.limite = quantidade;

        Principal.valor = new double[Principal.limite];
        Principal.peso = new double[Principal.limite];

        labelCont.setText("Quantidade de Itens: " + quantidade);
    }

    @FXML
    public void addItem() {

        Double valor = Double.parseDouble(valorItem.getText());
        Principal.valor[cont] = valor;

        Double peso = Double.parseDouble(pesoItem.getText());
        Principal.peso[cont] = peso;

        cont++;
        limparTextFild();
    }

    @FXML
    public void gerarGenetico(){

        Integer valor = Integer.parseInt(capacidadeMochila.getText());
        Principal.capacidade = valor;

        Genetico Ag = new Genetico();
        Time tempo = new Time();
        Ag.Iniciar();
        System.out.println("\nTempo de execução: " +  tempo );
        Runtime rt = Runtime.getRuntime();
        System.out.println("Uso de memória  = " +(rt.totalMemory()-rt.freeMemory())/(1000*1000)+"M");

    }
}
