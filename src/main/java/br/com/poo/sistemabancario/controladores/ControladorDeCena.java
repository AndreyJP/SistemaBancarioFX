package br.com.poo.sistemabancario.controladores;

import br.com.poo.sistemabancario.main.SistemaBancario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorDeCena {
    private static Stage stage;

    public static void setSceneStage(Stage stage){
        ControladorDeCena.stage = stage;
    }

    public static void trocarCena(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(ControladorDeCena.class.getResource("/br/com/poo/sistemabancario/" + fxmlPath));
        Parent root = loader.load();
        stage.setTitle("Sistema Bancário" + " - " + SistemaBancario.getBank().getNome());
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(new Scene(root));
    }
}
