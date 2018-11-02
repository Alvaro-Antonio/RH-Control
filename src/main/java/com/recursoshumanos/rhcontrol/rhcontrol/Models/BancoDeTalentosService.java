/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import com.recursoshumanos.rhcontrol.rhcontrol.repositories.BancoDeTalentosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author naian
 */
@Service
public class BancoDeTalentosService {
        
        @Autowired

	BancoDeTalentosRepository bancoDeTalentoRepository;

	public BancoDeTalentosService () {
	}

	public BancoDeTalentos getBuscarTalento(int id) {
		Optional<BancoDeTalentos> talento = bancoDeTalentoRepository.findById(id);
		
		return talento.orElse(null);
	}
        public List <BancoDeTalentos> findAll(){
		List <BancoDeTalentos> obj = bancoDeTalentoRepository.findAll();
		return obj;
	}
        public void remove(Integer id){
                bancoDeTalentoRepository.deleteById(id);
        
	}
        public void save (BancoDeTalentos bancoDeTalentos){
               bancoDeTalentoRepository.save(bancoDeTalentos);
        }
    
    
}
