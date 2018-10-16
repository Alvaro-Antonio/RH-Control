/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

public abstract class Pessoa {

	private int id;

	private String nome;
	private int idade;
	private String numeroRG;
	private String numeroCPF;
	private String telefone;
	private String endereco;
	private String dataDeNasc;
	private String email;
	private String habilidades;

	public Pessoa(int id, String nome, int idade, String numeroRG, String numeroCPF,
			String telefone, String endereco, String dataDeNasc, String email,
			String habilidades) {
		this.nome = nome;
		this.idade = idade;
		this.numeroRG = numeroRG;
		this.numeroCPF = numeroCPF;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataDeNasc = dataDeNasc;
		this.email = email;
		this.habilidades = habilidades;
		this.id = id;
	}
        public Pessoa(){};
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public void setDataDeNasc(String dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getNumeroRG() {
		return this.numeroRG;
	}

	public String getNumeroCPF() {
		return this.numeroCPF;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDataDeNasc() {
		return this.dataDeNasc;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}