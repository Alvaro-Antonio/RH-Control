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
 * @author alvaro
 */
@Entity
@Component
public class Selecao implements Serializable{
    private final static long serialVersionUID = 1L;
   
    
   
    @OneToMany(mappedBy="selecao")
    private List<Candidato> candidatos = new ArrayList<>();     
    private String tipoSelecao;
    private String dataSelecao;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    //private LocalDateTime data;
    public Selecao() {
    }

    public Selecao(Integer id ,String tipoSelecao, String dataSelecao) {
        this.id = id;
        this.tipoSelecao = tipoSelecao;
        this.dataSelecao = dataSelecao;
		  
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    
    /**
     * @return the tipoSelecao
     */
    public String getTipoSelecao() {
        return tipoSelecao;
    }

    /**
     * @param tipoSelecao the tipoSelecao to set
     */
    public void setTipoSelecao(String tipoSelecao) {
        this.tipoSelecao = tipoSelecao;
    }

    
    public String getDataSelecao() {
        return dataSelecao;
    }

    /*public void removeCandidato(Candidato can){
    candidatos.remove(can);
    }*/
    public void setDataSelecao(String dataSelecao) {    
        this.dataSelecao = dataSelecao;
    }

    @Override
    public int hashCode() {
        int hash = 9;
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
        final Selecao other = (Selecao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
