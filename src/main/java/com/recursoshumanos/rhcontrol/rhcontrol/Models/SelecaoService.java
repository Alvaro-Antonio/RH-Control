/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/**
 *
 * @author alvaro
 */

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CandidatoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelecaoService {
     @Autowired
        private CandidatoRepository repo;
     
     /*Busca por ID*/
        public Candidato find(Integer id){
            Optional<Candidato> obj = repo.findById(id);
            return obj.orElse(null);
        }
        public List<Candidato> findAll(){
            List<Candidato> obj = repo.findAll();
            return obj;
        }
        
         public void remove(Integer id){
                repo.deleteById(id);
        
	}
        public void save (Candidato candidato){
               repo.save(candidato);
        }
        
        public boolean create(Candidato c){
            try {
                repo.save(c);
                return true;
            } catch (Exception e) {
                return false;
            }
            
            
        }
}
