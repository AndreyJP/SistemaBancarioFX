package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.banco.Conta;
import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorTelaListaContas {

    public static final String FXML_PATH = "tela-lista-contas.fxml";

    @FXML
    TableView<Conta> tabelaContas;

    @FXML
    TableColumn<Conta, String> numeroConta;

    @FXML
    TableColumn<Conta, String> tipoConta;

    @FXML
    TableColumn<Conta, String> nomeProprietário;

    @FXML
    TableColumn<Conta, String> saldoConta;

    ArrayList<Conta> contas = SistemaBancario.getBank().getContas();
    ObservableList<Conta> contaObservableList;

    @FXML
    public void initialize(){
        numeroConta.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tipoConta.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        nomeProprietário.setCellValueFactory(cellData -> {
            Cliente proprietario = cellData.getValue().getProprietario();
            if (proprietario != null) {
                return new SimpleStringProperty(proprietario.getNome());
            } else {
                return new SimpleStringProperty("");
            }
        });
        saldoConta.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        contaObservableList = FXCollections.observableArrayList(contas);
        tabelaContas.setItems(contaObservableList);
    }

    @FXML
    protected void adicionarConta() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaCadastroConta.FXML_PATH);
    }

    @FXML
    protected void voltar() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaPrincipalAdmin.FXML_PATH);
    }
}
