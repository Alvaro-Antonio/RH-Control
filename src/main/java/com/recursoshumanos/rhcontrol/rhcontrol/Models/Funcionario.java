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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Funcionario  implements Serializable{
        
        private final static long serialVersionUID = 1L;
    
	//private List<Advertencia> advertencias= new ArrayList<Advertencia>();
	private String dataDaAdmicao;
	private int quantHorasExtrasMensal;
        
        private String nome;
	private int idade;
	private String numeroRG;
	private String numeroCPF;
	private String telefone;
	private String endereco;
	private String dataDeNasc;
	private String email;
	private String habilidades;
        
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="cargo_id")
        private Cargo cargo;
        
        @ManyToOne
        @JoinColumn(name="treinamento_id")
        private Treinamento treinamento;
        
        @OneToMany(mappedBy="funcionario")
        private List<Advertencia> advertencias = new ArrayList<>();

    public Funcionario() {
    }

	public Funcionario(Integer id,Cargo cargo,String dataDaAdmicao,Candidato candidato) {
                this.nome = candidato.getNome();
                this.idade = candidato.getIdade();
                this.numeroRG = candidato.getNumeroRG();
                this.numeroCPF = candidato.getNumeroCPF();
                this.telefone = candidato.getTelefone();
                this.endereco = candidato.getEndereco();
                this.email =  candidato.getEmail();
                this.habilidades = candidato.getHabilidades();
		this.dataDaAdmicao = dataDaAdmicao;
                this.id = id;
                this.cargo = cargo;
	}
	
	public List<Advertencia> getAdvertencias() {
		return advertencias;
	}

	public void addAdvertencias(Advertencia advertencia) {
		this.advertencias.add(advertencia);
        }
	public String getDataDaAdmicao() {
		return dataDaAdmicao;
	}

	public void setDataDaAdmicao(String dataDaAdmicao) {
		this.dataDaAdmicao = dataDaAdmicao;
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
