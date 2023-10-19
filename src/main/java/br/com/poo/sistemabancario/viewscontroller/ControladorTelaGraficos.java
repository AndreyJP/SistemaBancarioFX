package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.banco.Conta;
import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Cliente;
import br.com.poo.sistemabancario.usuarios.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorTelaGraficos {

    public static final String FXML_PATH = "tela-graficos.fxml";

    @FXML
    private PieChart graficoUsuarios;

    @FXML
    private BarChart graficoContas;

    ArrayList<Usuario> usuarios = SistemaBancario.getBank().getUsuarios();
    ArrayList<Conta> contas = SistemaBancario.getBank().getContas();

    @FXML
    public void initialize(){

        //Inicializa Gráfico de Usuários
        Map<String, Integer> tiposUsuarios = new HashMap<>();

        for (Usuario usuario : usuarios){
            String tipoUsuario = usuario.getTipo();
            tiposUsuarios.put(tipoUsuario, tiposUsuarios.getOrDefault(tipoUsuario, 0) + 1);
        }

        ArrayList<PieChart.Data> dadosGrafico = new ArrayList<>();

        for (Map.Entry<String, Integer> entrada : tiposUsuarios.entrySet()){
            PieChart.Data slice = new PieChart.Data(entrada.getKey() + " (" + entrada.getValue() + ")", entrada.getValue());
            dadosGrafico.add(slice);
        }

        ObservableList<PieChart.Data> dadosGraficoObservableList = FXCollections.observableArrayList(dadosGrafico);

        graficoUsuarios.getData().addAll(dadosGraficoObservableList);
        graficoUsuarios.setTitle("Quantidade de usuários");

        //Inicializa Gráfico de Contas

        int qtdeContaCorrente = 0;
        int qtdeContaPoupanca = 0;

        for (Conta conta : contas){
            switch (conta.getTipo()){
                case "Corrente": qtdeContaCorrente += 1;
                    break;
                case "Poupança": qtdeContaPoupanca += 1;
                    break;
            }
        }

        XYChart.Series<String, Number> seriesCorrente = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesPoupanca = new XYChart.Series<>();

        seriesCorrente.setName("Corrente");
        seriesPoupanca.setName("Poupança");

        seriesCorrente.getData().add(new XYChart.Data<>("Corrente", qtdeContaCorrente));
        seriesPoupanca.getData().add(new XYChart.Data<>("Poupança", qtdeContaPoupanca));

        graficoContas.getData().addAll(seriesCorrente, seriesPoupanca);
        graficoContas.setTitle("Quantidade de contas por tipo");
    }

    @FXML
    protected void voltar() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaPrincipalAdmin.FXML_PATH);
    }
}
