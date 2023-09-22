package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controller.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControladorTelaPrincipalAdmin {

    public static final String FXML_PATH = "tela-principal-admin.fxml";

    @FXML
    private Text boasVindas;

    @FXML
    protected void initialize(){
        boasVindas.setText("Usuario Logado: \n" + SistemaBancario.getUsuarioLogado().getNome());
    }

    @FXML
    protected void gerirUsuarios() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaListaUsuarios.FXML_PATH);
    }

    @FXML
    protected void gerirClientes() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaListaClientes.FXML_PATH);
    }

    @FXML
    protected void gerirFuncionarios(){
        System.out.println("Gerir Funcionários");
    }

    @FXML
    protected void gerirContas(){
        System.out.println("Gerir Contas");
    }

    @FXML
    protected void sair() throws IOException {
        SistemaBancario.setUsuarioLogado(null);
        ControladorDeCena.trocarCena(ControladorTelaLogin.FXML_PATH);
    }
}

