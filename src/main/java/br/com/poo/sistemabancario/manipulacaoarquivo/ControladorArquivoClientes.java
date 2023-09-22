package br.com.poo.sistemabancario.manipulacaoarquivo;

import br.com.poo.sistemabancario.usuarios.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ControladorArquivoClientes {
    private final String arquivoClientes = "arquivoClientes.ser";

    public void cadastrarClienteNoArquivo(Cliente cliente){
        ArrayList<Cliente> clientes = this.lerArquivoClientes();
        clientes.add(cliente);
        this.salvarArquivoClientes(clientes);
    }

    public ArrayList<Cliente> lerArquivoClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoClientes))) {
            clientes = (ArrayList<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            this.salvarArquivoClientes(clientes);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private void salvarArquivoClientes(ArrayList<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoClientes))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
