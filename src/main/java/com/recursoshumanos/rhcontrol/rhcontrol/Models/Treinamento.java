/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

/**
 *
 * @author alvaro.antonio
 */
@Entity
@Component
public class Treinamento implements Serializable {
	
	private static final long serialVersionUID = 1l;
	@Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
	
	@NotBlank(message = "O campo 'Nome' é obrigatório.")
	private String nome;
	@NotBlank(message = "O campo 'Tipo' é obrigatório.")
	private String tipo;
	@NotBlank(message = "O campo 'Data' é obrigatório.")
	private String data;
	@NotBlank(message = "O campo 'Local' é obrigatório.")
	private String local;
	@NotBlank(message = "O campo 'Horario' é obrigatório.")
	private String horario;
	
	@OneToMany(mappedBy="treinamento")
        List<Funcionario> funcionario = new ArrayList<Funcionario>();
	
        
        public Treinamento(Integer id, String nome, String tipo, String data, String local,String horario){
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
            this.data = data;
            this.local = local;
            this.horario = horario;
        }
        public Treinamento(){}
	public long getId() {
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Treinamento other = (Treinamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
	
	

}
