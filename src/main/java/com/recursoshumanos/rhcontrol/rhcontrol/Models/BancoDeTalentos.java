
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
public class BancoDeTalentos {
    
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
