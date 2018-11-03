package com.recursoshumanos.rhcontrol.rhcontrol;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Advertencia;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Funcionario;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Treinamento;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.AdvertenciaRepository;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CandidatoRepository;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CargoRepository;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.FuncionarioRepository;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.SelecaoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RhControlApplication implements CommandLineRunner{
    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private SelecaoRepository selecaoRepository;
    @Autowired 
    CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private AdvertenciaRepository advertenciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(RhControlApplication.class, args);
	}
     
    @Override    
    public void run(String... args) throws Exception{
        Selecao curriculo = new Selecao(null,"Curricular","31/10/2018");
        Selecao testeFisico = new Selecao(null,"testeFisico","20/12/2018");
       
        Candidato cand1 = new Candidato(null, true, "Ta bom", "Álvaro", 25, "sadsa", "asd", "8199999", "Universidade", "31/03/93", "alvaro@mail.com", "Linux, Shell",curriculo);
        Candidato cand2 = new Candidato(null, false, "Ta ruim", "Cicero", 26, "sadsa", "asd", "8199999", "Universidade", "30/07/91", "cicero@mail.com", "Linux, Shell",testeFisico);
        Candidato cand3 = new Candidato(null, true, "Ta bom", "Cicero", 40, "sadsa", "asd", "8199999", "Universidade", "31/03/93", "alvaro@mail.com", "Linux, Shell",curriculo);
        
        Cargo c1 =  new Cargo(null,"Eletricista",4.200,150,200,90);
        Cargo c2 =  new Cargo(null,"Mecânico",3000,150,200,90);
        Cargo c3 =  new Cargo(null,"Pedreiro",4000,150,200,90);
        Cargo c4 =  new Cargo(null,"Engenhriro Elétrico",5.500,150,200,90);
        
        
        Funcionario f1 = new Funcionario(null, c2, "01/11/2018", cand3);
        Funcionario f2 = new Funcionario(null, c1, "01/01/2018", cand1);

        curriculo.getCandidatos().addAll(Arrays.asList(cand1,cand2));
        testeFisico.getCandidatos().addAll(Arrays.asList(cand3));
        Advertencia ad1 = new Advertencia(null, "Atrasado", "04/09/2018", "Desviou do trabalho",f1);
        
        selecaoRepository.saveAll(Arrays.asList(curriculo,testeFisico));
        candidatoRepository.saveAll(Arrays.asList(cand1,cand2,cand3));
        cargoRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
        funcionarioRepository.saveAll(Arrays.asList(f1,f2));
        advertenciaRepository.saveAll(Arrays.asList(ad1));
    }
}
