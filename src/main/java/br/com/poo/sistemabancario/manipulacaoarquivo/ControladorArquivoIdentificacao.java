package br.com.poo.sistemabancario.manipulacaoarquivo;

import br.com.poo.sistemabancario.apoio.Identificacao;

import java.io.*;

public class ControladorArquivoIdentificacao {

    private static final String arquivoIdentificacao = "arquivoIdentificadores.ser";

    public static void salvarArquivoIdentificacao(Identificacao identificacao){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoIdentificacao))) {
            oos.writeObject(identificacao);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Identificacao lerArquivoIdentificacao(){
        Identificacao identificacao = new Identificacao();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoIdentificacao))){
            identificacao = (Identificacao) ois.readObject();
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            salvarArquivoIdentificacao(identificacao);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return identificacao;
    }

}
