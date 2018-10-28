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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Funcionario  implements Serializable{
        
        private final static long serialVersionUID = 1L;
    
	//private List<Advertencia> advertencias= new ArrayList<Advertencia>();
	private String dataDaAdmicao;
	private int quantAdvertencia;
	private int quantHorasExtrasMensal;
        @Id
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="cargo_id")
        private Cargo cargo;

    public Funcionario() {
    }

	public Funcionario(Integer id,Cargo cargo,String dataDaAdmicao,Candidato candidato) {
		this.dataDaAdmicao = dataDaAdmicao;
                this.id = id;
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
	/*public double getSalarioBruto() {
		double salario = cargo.getGratificacao() + cargo.getSalarioCargo() + cargo.getValeAlimentacao() + cargo.getValeTransporte()+ (quantHorasExtrasMensal * cargo.getValorHoraExtra());
		return salario;
	}
*/


	public int getQuantHorasExtrasMensal() {
		return quantHorasExtrasMensal;
	}



	public void setQuantHorasExtrasMensal(int quantHorasExtrasMensal) {
		this.quantHorasExtrasMensal = quantHorasExtrasMensal;
	}
        

    public Cargo getCargos() {
        return cargo;
    }

    //public void setAdvertencias(List<Advertencia> advertencias) {
    //	this.advertencias = advertencias;
    //}
    public void setCargos(Cargo cargos) {
        this.cargo = cargos;        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
	
	
}
