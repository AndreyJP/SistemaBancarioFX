package br.com.poo.sistemabancario.usuarios;

import java.io.Serializable;

public class Funcionario extends Usuario implements Serializable {
    private int matricula;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String usuario, String senha) {
        super(nome, usuario, senha, "Funcionário");
    }
}
