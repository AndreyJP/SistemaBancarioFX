package br.com.poo.sistemabancario.usuarios;

public class Funcionario extends Usuario{
    private int matricula;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String usuario, String senha) {
        super(nome, usuario, senha, "Funcionário");
    }
}
