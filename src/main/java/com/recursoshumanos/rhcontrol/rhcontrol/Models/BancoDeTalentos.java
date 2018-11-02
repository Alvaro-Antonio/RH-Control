package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author alvaro
 */
@Entity
@Component
public class BancoDeTalentos implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    private String nome;
    private int idade;
    private String numeroRG;
    private String numeroCPF;
    private String telefone;
    private String endereco;
    private String dataDeNasc;
    private String email;
    private String habilidades;

    public BancoDeTalentos(Integer id,Candidato cand) {
        this.id = id;
        this.nome = cand.getNome();
        this.idade = cand.getIdade();
        this.numeroRG = cand.getNumeroRG();
        this.numeroCPF = cand.getNumeroCPF();
        this.telefone = cand.getTelefone();
        this.endereco = cand.getEndereco();
        this.dataDeNasc = cand.getDataDeNasc();
        this.email = cand.getEmail();
        this.habilidades = cand.getHabilidades();
    }

    public BancoDeTalentos() {
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
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final BancoDeTalentos other = (BancoDeTalentos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
