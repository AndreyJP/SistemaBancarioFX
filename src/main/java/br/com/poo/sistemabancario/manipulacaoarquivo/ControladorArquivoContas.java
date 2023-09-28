package br.com.poo.sistemabancario.manipulacaoarquivo;

import br.com.poo.sistemabancario.banco.Conta;
import br.com.poo.sistemabancario.usuarios.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ControladorArquivoContas {

    private final String ARQUIVO_CONTAS = "arquivoContas.ser";

    public void cadastrarContaNoArquivo(Conta conta){
        ArrayList<Conta> contas = this.lerArquivoContas();
        contas.add(conta);
        this.salvarArquivoContas(contas);
    }

    public ArrayList<Conta> lerArquivoContas(){
        ArrayList<Conta> contas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTAS))) {
            contas = (ArrayList<Conta>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            this.salvarArquivoContas(contas);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contas;
    }

    private void salvarArquivoContas(ArrayList<Conta> contas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTAS))) {
            oos.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
