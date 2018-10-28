/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
@Entity
public class Candidato implements Serializable{
        
        private final static long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
        
        @ManyToOne
        @JoinColumn(name="candidato_id")
        private Selecao selecao;
	private boolean aprovacao;
	private String avaliacaoGeral;	
        
        private String nome;
	private int idade;
	private String numeroRG;
	private String numeroCPF;
	private String telefone;
	private String endereco;
	private String dataDeNasc;
	private String email;
	private String habilidades;
        
	
    public Candidato(Integer id, boolean aprovacao, String avaliacaoGeral, String nome, int idade, String numeroRG, String numeroCPF, String telefone, String endereco, String dataDeNasc, String email, String habilidades) {
        this.id = id;
        this.aprovacao = aprovacao;
        this.avaliacaoGeral = avaliacaoGeral;
        this.nome = nome;
        this.idade = idade;
        this.numeroRG = numeroRG;
        this.numeroCPF = numeroCPF;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataDeNasc = dataDeNasc;
        this.email = email;
        this.habilidades = habilidades;
    }

    public Candidato(){};
             
	public String getNome(String nome) {
		return this.nome;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNumeroRG() {
        return numeroRG;
    }

    public void setNumeroRG(String numeroRG) {
        this.numeroRG = numeroRG;
    }

    public String getNumeroCPF() {
        return numeroCPF;
    }

    public void setNumeroCPF(String numeroCPF) {
        this.numeroCPF = numeroCPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataDeNasc() {
        return dataDeNasc;
    }

    public void setDataDeNasc(String dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidato other = (Candidato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
	
	
}
