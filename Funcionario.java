package com.mycompany.empresa7arraylist;

/**
 *
 * @author REUTER
 */
public class Funcionario {
     private String nome;
    private Cargo cargo;
    private double salario;

    public Funcionario(String nome, Cargo cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String mostraFunc() {
        return "Nome: " + nome + " || Cargo: " + cargo + " || Salário: R$" + salario;
    }
}
