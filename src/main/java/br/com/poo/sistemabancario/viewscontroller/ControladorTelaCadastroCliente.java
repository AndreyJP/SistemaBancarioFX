package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controller.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class ControladorTelaCadastroCliente {

    public static final String FXML_PATH = "tela-cadastro-cliente.fxml";

    @FXML
    TextField nomeCliente;

    @FXML
    TextField cpfCliente;

    @FXML
    TextField usuarioCliente;

    @FXML
    PasswordField senhaUsuario;

    @FXML
    TextField profissaoCliente;

    @FXML
    TextField enderecoCliente;

    private Consumer<Cliente> cadastroConcluidoCallback;

    public void setCadastroConcluidoCallback(Consumer<Cliente> cadastroConcluidoCallback) {
        this.cadastroConcluidoCallback = cadastroConcluidoCallback;
    }

    @FXML
    protected void cadastrar() throws IOException {

        if (!nomeCliente.getText().isBlank() && !cpfCliente.getText().isBlank() && !usuarioCliente.getText().isBlank() && !senhaUsuario.getText().isBlank()){
            Cliente cliente = new Cliente(nomeCliente.getText(), usuarioCliente.getText(), senhaUsuario.getText(), cpfCliente.getText());
            if (!profissaoCliente.getText().isBlank()){
                cliente.setProfissao(profissaoCliente.getText());
            }
            if(!enderecoCliente.getText().isBlank()){
                cliente.setEndereco(enderecoCliente.getText());
            }

            SistemaBancario.getBank().cadastrarCliente(cliente);

            if(cadastroConcluidoCallback != null){
                cadastroConcluidoCallback.accept(cliente);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Cadastro realizado com sucesso!");
            alert.show();

            this.limparInputs();
            ControladorDeCena.trocarCena(ControladorTelaListaClientes.FXML_PATH);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dados inválidos");
            alert.setHeaderText("Erro ao cadastrar cliente");
            alert.setContentText("Preencha todos os campos obrigatórios!");
            alert.show();
        }

    }

    @FXML
    protected void cancelar() throws IOException {
        this.limparInputs();
        ControladorDeCena.trocarCena(ControladorTelaListaClientes.FXML_PATH);
    }

    protected void fecharModal(){
        this.limparInputs();
        Stage stage = (Stage) nomeCliente.getScene().getWindow();
        stage.close();
    }

    protected void limparInputs(){
        nomeCliente.clear();
        cpfCliente.clear();
        profissaoCliente.clear();
        enderecoCliente.clear();
    }

}
