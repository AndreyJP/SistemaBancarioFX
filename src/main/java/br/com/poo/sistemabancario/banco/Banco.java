package br.com.poo.sistemabancario.banco;

import br.com.poo.sistemabancario.manipulacaoarquivo.ControladorArquivoClientes;
import br.com.poo.sistemabancario.manipulacaoarquivo.ControladorArquivoUsuarios;
import br.com.poo.sistemabancario.usuarios.Administrador;
import br.com.poo.sistemabancario.usuarios.Cliente;
import br.com.poo.sistemabancario.usuarios.Usuario;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Conta> contas;
    private ArrayList<Cliente> clientes;

    //Controladores de Arquivo
    private final ControladorArquivoUsuarios controladorArquivoUsuario = new ControladorArquivoUsuarios();
    private final ControladorArquivoClientes controladorArquivoClientes = new ControladorArquivoClientes();

    public Banco(String nome) {
        this.nome = nome;
        this.usuarios = controladorArquivoUsuario.lerArquivoUsuarios();
        this.clientes = controladorArquivoClientes.lerArquivoClientes();
        this.contas = new ArrayList<>();
        this.criarUsuarioAdminPadrao();
    }

    public Usuario login(String usuario, String senha){
        this.usuarios = controladorArquivoUsuario.lerArquivoUsuarios();
        Usuario usuarioLogado = null;
        for (Usuario usuarioSalvo : this.usuarios) {
            if(usuarioSalvo != null) {
                if (usuarioSalvo.getUsuario().equals(usuario) && usuarioSalvo.getSenha().equals(senha)) {
                    usuarioLogado = usuarioSalvo;
                }
            }
        }
        return usuarioLogado;
    }

    public void criarUsuarioAdminPadrao(){
        //Cria o admin padrão se ele não existir
        if(!this.usuarioExiste("admin")){
            Administrador administradorPadrao = new Administrador("Administrador Padrão", "admin", "master");
            this.usuarios.add(administradorPadrao);
            controladorArquivoUsuario.cadastrarUsuarioNoArquivo(administradorPadrao);
            this.usuarios = controladorArquivoUsuario.lerArquivoUsuarios();
        }
    }

    public void cadastrarCliente(Cliente cliente){
        this.getClientes().add(cliente);
        this.getUsuarios().add(cliente);
        controladorArquivoClientes.cadastrarClienteNoArquivo(cliente);
        controladorArquivoUsuario.cadastrarUsuarioNoArquivo(cliente);
    }

    public boolean usuarioExiste(String usuario){
        boolean jaExiste = false;
        this.usuarios = controladorArquivoUsuario.lerArquivoUsuarios();
        for (Usuario usuarioLido : this.usuarios){
            if(usuarioLido.getUsuario().equals(usuario)){
                jaExiste = true;
                break;
            }
        }
        return jaExiste;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Usuario> getUsuarios(){
        this.usuarios = controladorArquivoUsuario.lerArquivoUsuarios();
        return this.usuarios;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
}