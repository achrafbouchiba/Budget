package com.vermeg.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vermeg.budget.repositories.ChiffreAffaireRepository;
import com.vermeg.budget.repositories.ContactRepository;
import com.vermeg.budget.repositories.ProjetRepository;
import com.vermeg.budget.services.BudgetEmployeeService;
import com.vermeg.budget.services.impl.BudgetEmployeeServiceImpl;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class})
public class BudgetApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private ChiffreAffaireRepository chiffreAffaireRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Projet projet = new Projet();
//		projet.setCapitalisable(null);
//		projet.setNomProjet("Projet1");
//		projet.setProbabilite("100%");
//		projet.setTypeCa("Maintenance Correctives");
//		projet.setWorkLoadTot("720");
//		projet.setSociete("Vermeg Solution");
//		projet.setClient("Cl1");
//		projet.setLot("V10");
//		projetRepository.save(projet);
//		Contact contact =new Contact();
//		contact.setNom("Bouchiba");
//		contact.setEmail("achraf@gmail.com");
//		contact.setPassword("1234");
//		contact.setPrenom("Achraf");
//		contact.setUsername("Bouch");
//		contactRepository.save(contact);
		// Workload

//		workload.setClient("Client1");
//		workload.setLot("V30");
//		workload.setPhase("bbbb");
//		workload.setSociete("Vermeg Solution");
//		workload.setTypeCa("Maintenance Correctives");
//		workload.setProjet("projet 1");
//		workload.setWorkLoadTotal("750");
//		workload.setProduit("Solife Service");
//		workloadRepository.save(workload);
		// chiffreAffaireRepository.getRecapTypeCa("2019").forEach(rec->
		// System.out.println(rec));


	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
