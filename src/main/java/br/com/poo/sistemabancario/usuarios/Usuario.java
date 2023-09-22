package br.com.poo.sistemabancario.usuarios;

import br.com.poo.sistemabancario.apoio.Identificacao;
import br.com.poo.sistemabancario.manipulacaoarquivo.ControladorArquivoIdentificacao;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private int id;
    private String tipo;
    private String nome;
    private String usuario;
    private String senha;

    public Usuario(String nome, String usuario, String senha, String tipo) {
        this.tipo = tipo;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        Identificacao identificacao = ControladorArquivoIdentificacao.lerArquivoIdentificacao();
        this.id = identificacao.gerarIDUsuario();
        ControladorArquivoIdentificacao.salvarArquivoIdentificacao(identificacao);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }
}
