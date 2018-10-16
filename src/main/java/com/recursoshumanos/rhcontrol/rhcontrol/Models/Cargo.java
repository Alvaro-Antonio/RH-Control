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
public class Cargo {
	private String nomeCargo;
	private double salarioCargo;
	private double gratificacao;
	private double valorHoraExtra;
	private double valeAlimentacao;
	private double valeTransporte;
        private int id;
    
	public Cargo(int id,String nomeCargo, double salarioCargo, double gratificacao, double valeAlimentacao,
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        
}
