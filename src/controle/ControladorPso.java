package controle;

import ag.Genetico;
import ag.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pso.Nuvem;
import pso.Start;
import util.Time;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorPso implements Initializable {

    @FXML
    private Button btnItens, btDadosItens, btnGerar;

    @FXML
    private TextField qtdItens, valorItem, pesoItem, capacidadeMochila;

    @FXML
    private Label labelValores, labelPesos;

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
        Start.qtd = quantidade;

        Start.valores = new double[Start.qtd];
        Start.pesos = new double[Start.qtd];

        //labelCont.setText("Quantidade de Itens: " + quantidade);
    }

    @FXML
    public void addItem() {

        Double valor = Double.parseDouble(valorItem.getText());
        Start.valores[cont] = valor;

        Double peso = Double.parseDouble(pesoItem.getText());
        Start.pesos[cont] = peso;

        cont++;
        limparTextFild();

        labelValores.setText("Valores: " + "" + Start.retornarV() + "");
        labelPesos.setText("Pesos: " + "" + Start.retornarP() + "");
    }

    @FXML
    public void gerarGenetico(){

        Integer valor = Integer.parseInt(capacidadeMochila.getText());
        Start.capacidade = valor;

        Nuvem nuvemParticulas = new Nuvem(100);
        Time tempo = new Time();
        nuvemParticulas.executarPSO();

        System.out.println(nuvemParticulas.getMelhorSolucaoNuvem());
        System.out.println("\nTempo de execução: " +  tempo );
        Runtime rt = Runtime.getRuntime();
        System.out.println("Uso de memória  = " +(rt.totalMemory()-rt.freeMemory())/(1000*1000)+"M");

    }
}
