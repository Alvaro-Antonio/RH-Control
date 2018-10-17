/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alvaro
 */
@Service
public class Selecao {        
    
    private List<Candidato> candidatos = new ArrayList<Candidato>();     
    private String tipoSelecao;
    
    //private LocalDateTime data;
    public Selecao() {
    }

    public Selecao(List<Candidato> candidatos, String tipoSelecao) {
        this.candidatos = candidatos;
        this.tipoSelecao = tipoSelecao;
		  
	  
	    Candidato c1 = new Candidato(3,"Fulano", 27, "92122156", "45414545", "(81)9239-2343", "", "1233", "fulano@mail.com", "nenhuma", "top");
	    Candidato c2 = new Candidato(4,"Ciclano", 27, "92452156", "45414545", "(81)9239-2343", "", "1233", "fulano@mail.com", "nenhuma", "top");
	    candidatos.add(c1);
	    candidatos.add(c2);
    }

    /**
     * @return the candidatos
     */
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    /**
     * @param candidatos the candidatos to set
     */
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
    
    public void removeCandidato(Candidato can){
        candidatos.remove(can);
    }
    
    
}
