package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import com.recursoshumanos.rhcontrol.rhcontrol.repositories.AdvertenciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author naian
 */
@Service
public class AdvertenciaService {
        
        @Autowired

	AdvertenciaRepository advertenciaRepository;

	public AdvertenciaService () {
	}

	public  Advertencia getBuscarAdvertencia(int id) {
		Optional<Advertencia> advertencias = advertenciaRepository.findById(id);
		
		return advertencias.orElse(null);
	}
        public List <Advertencia> findAll(){
		List <Advertencia> obj = advertenciaRepository.findAll();
		return obj;
	}
        public void remove(Integer id){
                advertenciaRepository.deleteById(id);
        
	}
        public void save (Advertencia bancoDeTalentos){
               advertenciaRepository.save(bancoDeTalentos);
        }
    
}