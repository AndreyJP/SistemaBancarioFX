package br.com.poo.sistemabancario.banco;

import br.com.poo.sistemabancario.usuarios.Cliente;

import java.io.Serializable;

public class Conta implements Serializable {
    private String tipo;
    private String numero;
    private double saldo;
    private Cliente proprietario;
    private String nomeBanco;

    public Conta(String tipo, String numero, Cliente proprietario, String banco) {
        this.tipo = tipo;
        this.numero = numero;
        this.saldo = 0.0;
        this.proprietario = proprietario;
        this.nomeBanco = banco;
    }

    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo = this.saldo - valor;
            return true;
        }else{
            return false;
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean transferir(Conta conta, double valor){
        if(this.saldo >= valor){
            this.saldo = this.saldo - valor;
            conta.depositar(valor);
            return true;
        }else{
            return false;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }
}
