package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controller.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControladorTelaPrincipalCliente {

    public static final String FXML_PATH = "tela-principal-cliente.fxml";

    @FXML
    private Text boasVindas;

    @FXML
    protected void initialize(){
        boasVindas.setText("Usuario Logado: \n" + SistemaBancario.getUsuarioLogado().getNome());
    }

    @FXML
    protected void acessarContas(){
        System.out.println("Acessar Contas");
    }

    @FXML
    protected void sair() throws IOException {
        SistemaBancario.setUsuarioLogado(null);
        ControladorDeCena.trocarCena(ControladorTelaLogin.FXML_PATH);
    }
}

