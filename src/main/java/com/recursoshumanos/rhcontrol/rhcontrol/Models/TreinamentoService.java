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

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Treinamento;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.TreinamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinamentoService {
     @Autowired
        private TreinamentoRepository repo;
     
     /*Busca por ID*/
        public Treinamento find(Integer id){
            Optional<Treinamento> obj = repo.findById(id);
            return obj.orElse(null);
        }
        public List<Treinamento> findAll(){
            List<Treinamento> obj = repo.findAll();
            return obj;
        }
        
         public void remove(Integer id){
                repo.deleteById(id);
        
	}
        public void save (Treinamento treinamento){
               repo.save(treinamento);
        }
        
        public boolean create(Treinamento c){
            try {
                repo.save(c);
                return true;
            } catch (Exception e) {
                return false;
            }
            
            
        }
}
