package br.com.poo.sistemabancario.main;

import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.banco.Banco;
import br.com.poo.sistemabancario.usuarios.Usuario;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SistemaBancario extends Application {

    private static Banco banco = new Banco("Banco de Exemplo");
    private static Usuario usuarioLogado = null;

    @Override
    public void start(Stage stage) throws IOException {
        ControladorDeCena.setSceneStage(stage);
        ControladorDeCena.trocarCena("tela-login.fxml");
        stage.setResizable(false);
        stage.show();
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        SistemaBancario.usuarioLogado = usuarioLogado;
    }

    public static Banco getBank(){
        return banco;
    }

    public static Usuario getUsuarioLogado(){
        return usuarioLogado;
    }

    public static void main(String[] args) {
        launch();
    }
}