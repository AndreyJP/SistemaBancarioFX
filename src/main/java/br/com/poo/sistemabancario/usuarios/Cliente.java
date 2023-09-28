package br.com.poo.sistemabancario.usuarios;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
    private String cpf;
    private String endereco;
    private String profissao;

    public Cliente(String nome, String usuario, String senha, String cpf) {
        super(nome, usuario, senha, "Cliente");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}