/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author alvaro
 */
@Entity
@Component
public class Selecao implements Serializable{
    private final static long serialVersionUID = 1L;
   
    @ManyToOne
    @JoinColumn(name="candidato_id")
    @MapsId
    private Candidato candidatos;     
    private String tipoSelecao;
    
    @Id
    private Integer id;
    //private LocalDateTime data;
    public Selecao() {
    }

    public Selecao(String tipoSelecao) {
        
        this.tipoSelecao = tipoSelecao;
		  
	  
	    Candidato c1 = new Candidato(3,"Fulano", 27, "92122156", "45414545", "(81)9239-2343", "", "1233", "fulano@mail.com", "nenhuma", "top");
	    Candidato c2 = new Candidato(4,"Ciclano", 27, "92452156", "45414545", "(81)9239-2343", "", "1233", "fulano@mail.com", "nenhuma", "top");
	    //candidatos.add(c1);
	    //candidatos.add(c2);
    }

    /**
     * @return the candidatos
     */
    public Candidato getCandidatos() {
        return candidatos;
    }

    
    public void setCandidatos(Candidato candidatos) {
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
