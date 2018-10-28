/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.List;
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
    private List<Candidato> candidatos;     
    private String tipoSelecao;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    //private LocalDateTime data;
    public Selecao() {
    }

    public Selecao(String tipoSelecao) {
        
        this.tipoSelecao = tipoSelecao;
		  
    }

    /**
     * @return the candidatos
     */
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    
    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
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
    
    /*public void removeCandidato(Candidato can){
        candidatos.remove(can);
    }*/
    
    
}
