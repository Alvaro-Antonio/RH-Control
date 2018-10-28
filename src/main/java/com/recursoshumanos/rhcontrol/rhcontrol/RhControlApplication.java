package com.recursoshumanos.rhcontrol.rhcontrol;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CandidatoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RhControlApplication implements CommandLineRunner{
    @Autowired
    private CandidatoRepository candidatoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RhControlApplication.class, args);
	}
     
    @Override    
    public void run(String... args) throws Exception{
        Candidato cand1 = new Candidato(null, true, "Ta bom", "Álvaro", 0, "sadsa", "asd", "8199999", "Universidade", "31/03/93", "alvaro@mail.com", "Linux, Shell");
        Candidato cand2 = new Candidato(null, false, "Ta ruim", "Cicero", 0, "sadsa", "asd", "8199999", "Universidade", "30/07/91", "cicero@mail.com", "Linux, Shell");
        
        candidatoRepository.saveAll(Arrays.asList(cand1,cand2));
    }
}
