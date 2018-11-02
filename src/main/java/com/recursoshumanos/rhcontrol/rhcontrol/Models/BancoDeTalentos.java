
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author alvaro
 */
@Entity
@Component
public class BancoDeTalentos implements Serializable{
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
    @Autowired
    private List<Candidato> talentos;
    
    public void getAddtalento(Candidato candidato) {
        talentos.add(candidato);
    }
    
    public List<Candidato> getTalento(String habil){
        List<Candidato> canditoshabils = new ArrayList<>();
        habil.toLowerCase();
        for(Candidato k : talentos){
            if(k.getHabilidades().toLowerCase().contains(habil)){
                canditoshabils.add(k);
            }
        }        
        return canditoshabils;
    }
}
