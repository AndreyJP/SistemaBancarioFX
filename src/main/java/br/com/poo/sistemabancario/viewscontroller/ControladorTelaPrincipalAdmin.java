package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

import static br.com.poo.sistemabancario.viewscontroller.ControladorTelaGraficos.FXML_PATH;

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
    protected void gerirContas() throws IOException {
       ControladorDeCena.trocarCena(ControladorTelaListaContas.FXML_PATH);
    }

    @FXML
    protected void consultarGraficos() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaGraficos.FXML_PATH);
    }

    @FXML
    protected void consultarVideos() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaVideos.FXML_PATH);
    }

    @FXML
    protected void sair() throws IOException {
        SistemaBancario.setUsuarioLogado(null);
        ControladorDeCena.trocarCena(ControladorTelaLogin.FXML_PATH);
    }
}

