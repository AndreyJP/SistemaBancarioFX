package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.banco.Conta;
import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import br.com.poo.sistemabancario.main.SistemaBancario;
import br.com.poo.sistemabancario.usuarios.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorTelaCadastroConta {

    public static final String FXML_PATH = "tela-cadastro-conta.fxml";

    @FXML
    TextField numeroConta;

    @FXML
    ComboBox tipoConta;

    @FXML
    ComboBox<Cliente> proprietarioConta;

    private ArrayList<String> tipos = new ArrayList<>();
    private ArrayList<Cliente> clientes = SistemaBancario.getBank().getClientes();

    @FXML
    public void initialize(){
        tipos.add("Corrente");
        tipos.add("Poupança");

        tipoConta.getItems().addAll(tipos);
        proprietarioConta.getItems().addAll(clientes);
        proprietarioConta.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Cliente> call(ListView<Cliente> clienteListView) {
                return new ListCell<>() {
                    protected void updateItem(Cliente item, boolean vazio) {
                        super.updateItem(item, vazio);
                        if (item != null && !vazio) {
                            setText(item.getNome());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
        proprietarioConta.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Cliente item, boolean vazio) {
                super.updateItem(item, vazio);
                if (item != null && !vazio) {
                    setText(item.getNome());
                } else {
                    setText(null);
                }
            }
        });
    }

    @FXML
    protected void cadastrar() throws IOException {

        if(!numeroConta.getText().isBlank() && tipoConta.getValue() != null && proprietarioConta.getValue() != null){
            Conta conta = new Conta(tipoConta.getValue().toString(), numeroConta.getText(), proprietarioConta.getValue(), SistemaBancario.getBank().getNome());
            SistemaBancario.getBank().cadastrarConta(conta);
            ControladorDeCena.trocarCena(ControladorTelaListaContas.FXML_PATH);

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao cadastrar conta");
            alert.setContentText("Preencha todos os campos obrigatórios");
            alert.show();
        }

    }

    @FXML
    protected void cancelar() throws IOException {
        this.limparInputs();
        ControladorDeCena.trocarCena(ControladorTelaListaContas.FXML_PATH);
    }

    protected void limparInputs(){
        numeroConta.clear();
    }

}
