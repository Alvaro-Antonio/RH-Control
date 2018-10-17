/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class Candidato extends Pessoa {
	private boolean aprovacao;
	private String avaliacaoGeral;	
        
	public Candidato(int id,String nome, int idade, String numeroRG, String numeroCPF, String telefone, String endereco,
			String dataDeNasc, String email,String habilidades,String avaliacao) {
		super(id,nome, idade, numeroRG, numeroCPF, telefone, endereco, dataDeNasc, email,habilidades);
		this.avaliacaoGeral = avaliacao;
		
	}

    public Candidato(){};
             
	public String getNome(String nome) {
		return super.getNome();
	}
	public boolean isAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}
	public String getAvaliacaoGeral() {
		return avaliacaoGeral;
	}
	public void setAvaliacaoGeral(String avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}
	
	
}
