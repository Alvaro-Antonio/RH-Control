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
import org.springframework.stereotype.Component;

/**
 *
 * @author user
*/

@Component
@Entity
public class Cargo implements Serializable{
        
        private final static long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        
        
        @OneToMany(mappedBy="cargo")
        List<Funcionario> funcionario = new ArrayList<Funcionario>();
        
	private String nomeCargo;
	private double salarioCargo;
	private double gratificacao;
	private double valorHoraExtra;
	private double valeAlimentacao;
	private double valeTransporte;
        
    
	public Cargo(Integer id,String nomeCargo, double salarioCargo, double gratificacao, double valeAlimentacao,
			double valeTransporte) {
		this.nomeCargo = nomeCargo;
		this.salarioCargo = salarioCargo;
		this.gratificacao = gratificacao;
		this.id = id;
		this.valeAlimentacao = valeAlimentacao;
		this.valeTransporte = valeTransporte;
                
	}
        public Cargo(){};

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public double getSalarioCargo() {
		return salarioCargo;
	}

	public void setSalarioCargo(double salarioCargo) {
		this.salarioCargo = salarioCargo;
	}

	public double getGratificacao() {
		return gratificacao;
	}

	public void setGratificacao(double gratificacao) {
		this.gratificacao = gratificacao;
	}

	public double getValorHoraExtra() {
		return valorHoraExtra;
	}

	public void setValorHoraExtra(double horaExtra) {
		this.valorHoraExtra = horaExtra;
	}

	public double getValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(double valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public double getValeTransporte() {
		return valeTransporte;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        
        
        
}
