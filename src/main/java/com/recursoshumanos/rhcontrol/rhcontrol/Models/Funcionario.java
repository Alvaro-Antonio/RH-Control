/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/**
 *
 * @author user
 */

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	private Cargo cargo;
	//private List<Advertencia> advertencias= new ArrayList<Advertencia>();
	private String dataDaAdmicao;
	private int quantAdvertencia;
	private int quantHorasExtrasMensal;

	public Funcionario(Cargo cargo, String dataDaAdmicao,Candidato candidato) {
		super(candidato.getId(),candidato.getNome(), candidato.getIdade(), candidato.getNumeroRG(), candidato.getNumeroCPF(),candidato.getTelefone(),candidato.getEndereco(),candidato.getDataDeNasc(),candidato.getEmail(),candidato.getHabilidades());
		this.cargo = cargo;
		this.dataDaAdmicao = dataDaAdmicao;
	}
	
	

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/*public List<Advertencia> getAdvertencias() {
		return advertencias;
	}

	public void addAdvertencias(Advertencia advertencias) {
		this.advertencias.add(advertencias);
	}*/

	public String getDataDaAdmicao() {
		return dataDaAdmicao;
	}

	public void setDataDaAdmicao(String dataDaAdmicao) {
		this.dataDaAdmicao = dataDaAdmicao;
	}

	public int getQuantAdvertencia() {
		return quantAdvertencia;
	}

	public void setQuantAdvertencia(int quantAdvertencia) {
		this.quantAdvertencia = quantAdvertencia;
	}
	public double getSalarioBruto() {
		double salario = cargo.getGratificacao() + cargo.getSalarioCargo() + cargo.getValeAlimentacao() + cargo.getValeTransporte()+ (quantHorasExtrasMensal * cargo.getValorHoraExtra());
		return salario;
	}



	public int getQuantHorasExtrasMensal() {
		return quantHorasExtrasMensal;
	}



	public void setQuantHorasExtrasMensal(int quantHorasExtrasMensal) {
		this.quantHorasExtrasMensal = quantHorasExtrasMensal;
	}



	//public void setAdvertencias(List<Advertencia> advertencias) {
	//	this.advertencias = advertencias;
	//}
	
	
}
