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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author naian
 */
@Entity
@Component
public class Advertencia implements Serializable{
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="funcionario_id")
        private Funcionario funcionario;
        
	private String nomeDaAdvertencia;
        private String data;
        private String descricao;
        
        public Advertencia (Integer id, String nomeDaAdvertencia, String data, String descricao ,Funcionario f1) {
            this.id=id;
            this.data=data;
            this.nomeDaAdvertencia = nomeDaAdvertencia;
            this.descricao=descricao;
            this.funcionario = f1;
            
        }
        
        public Advertencia(){};

	public String nomeDaAdvertencia() {
		return nomeDaAdvertencia;
	}

	public void setnomeDaAdvertencia(String nomeDaAdvertencia) {
		this.nomeDaAdvertencia = nomeDaAdvertencia;
	}
        
        public String data(){
               return data;
        }
        
        public void setdata(String data){
            this.data= data;
        }
        
        public String descricao(){
            return descricao;
        }
        
        public void setDescricao(String descricao){
            this.descricao=descricao;
        }
        
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(Advertencia advertencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Advertencia getBuscarAdvertencia(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
