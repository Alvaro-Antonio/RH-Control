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
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario  {
    
	private Cargo cargo;
	//private List<Advertencia> advertencias= new ArrayList<Advertencia>();
	private String dataDaAdmicao;
	private int quantAdvertencia;
	private int quantHorasExtrasMensal;
        @Id
        private Integer id;

	public Funcionario(Cargo cargo, String dataDaAdmicao,Candidato candidato) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
	
}
