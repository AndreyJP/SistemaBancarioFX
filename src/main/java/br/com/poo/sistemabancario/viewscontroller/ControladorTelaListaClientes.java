package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorTelaListaClientes {

    public static final String FXML_PATH = "tela-lista-clientes.fxml";

    @FXML
    TableView<Cliente> tabelaCliente;

    @FXML
    TableColumn<Cliente, String> nomeCliente;

    @FXML
    TableColumn<Cliente, String> cpfCliente;

    @FXML
    TableColumn<Cliente, String> profissaoCliente;

    @FXML
    TableColumn<Cliente, String> enderecoCliente;

    ArrayList<Cliente> clientes = SistemaBancario.getBank().getClientes();
    ObservableList<Cliente> clienteObservableList;

    @FXML
    public void initialize(){
        nomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfCliente.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        profissaoCliente.setCellValueFactory(new PropertyValueFactory<>("profissao"));
        enderecoCliente.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        clienteObservableList = FXCollections.observableArrayList(clientes);
        tabelaCliente.setItems(clienteObservableList);
    }

    @FXML
    protected void adicionarCliente() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaCadastroCliente.FXML_PATH);
    }

    @FXML
    protected void voltar() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaPrincipalAdmin.FXML_PATH);
    }
}
