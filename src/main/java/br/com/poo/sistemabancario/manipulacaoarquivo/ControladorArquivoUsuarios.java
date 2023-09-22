package br.com.poo.sistemabancario.manipulacaoarquivo;

import br.com.poo.sistemabancario.usuarios.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ControladorArquivoUsuarios {

    private final String arquivoUsuarios = "arquivoUsuarios.ser";

    public void cadastrarUsuarioNoArquivo(Usuario usuario){
        ArrayList<Usuario> usuarios = this.lerArquivoUsuarios();
        usuarios.add(usuario);
        this.salvarArquivoUsuarios(usuarios);
    }

    public ArrayList<Usuario> lerArquivoUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoUsuarios))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            this.salvarArquivoUsuarios(usuarios);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private void salvarArquivoUsuarios(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoUsuarios))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
