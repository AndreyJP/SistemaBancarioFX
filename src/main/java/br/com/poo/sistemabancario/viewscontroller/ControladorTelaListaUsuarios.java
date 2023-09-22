package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controller.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorTelaListaUsuarios {

    public static final String FXML_PATH = "tela-lista-usuarios.fxml";

    @FXML
    TableView<Usuario> tabelaUsuario;

    @FXML
    TableColumn<Usuario, String> idusuario;

    @FXML
    TableColumn<Usuario, String> nomeUsuario;

    @FXML
    TableColumn<Usuario, String> loginUsuario;

    @FXML
    TableColumn<Usuario, String> tipoUsuario;


    ArrayList<Usuario> usuarios = SistemaBancario.getBank().getUsuarios();
    ObservableList<Usuario> usuarioObservableList;

    @FXML
    public void initialize(){
        idusuario.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
        loginUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        usuarioObservableList = FXCollections.observableArrayList(usuarios);
        tabelaUsuario.setItems(usuarioObservableList);
    }

    @FXML
    protected void voltar() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaPrincipalAdmin.FXML_PATH);
    }

}
