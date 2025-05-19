package Yahya.Ghallali;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Yahya.Ghallali.Entities.Client;
import Yahya.Ghallali.Entities.Credit;
import Yahya.Ghallali.Entities.CreditImmobilier;
import Yahya.Ghallali.Entities.CreditPersonnel;
import Yahya.Ghallali.Entities.CreditProfessionnel;
import Yahya.Ghallali.Entities.Remboursement;
import Yahya.Ghallali.Entities.ENUMS.Bien;
import Yahya.Ghallali.Entities.ENUMS.Status;
import Yahya.Ghallali.Entities.ENUMS.Type;
import Yahya.Ghallali.Repositories.*;
import Yahya.Ghallali.Services.Implementations.ClientServiceImpl;
import Yahya.Ghallali.Repositories.CreditImmobilierRepository;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class GhallaliApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhallaliApplication.class, args);
	}

	@Bean
	CommandLineRunner runTestDAO(
			ClientRepository clientRepository,
			CreditRepository creditRepository,
			CreditImmobilierRepository creditImmobilierRepository,
			CreditProfessionnelRepository creditProfessionnelRepository,
			CreditPersonnelRepository creditPersonnelRepository,
			RemboursementRepository remboursementRepository) {
		return args -> {
			System.out.println("Application started");

			Stream.of("Yahya", "Ghayah", "GH", "AB", "Jill").forEach(name -> {
				Client client = Client.builder()
						.nom(name)
						.email(name + "@gmail.com")
						.build();
				clientRepository.save(client);
			});

			List<Client> clients = clientRepository.findAll();
			System.out.println("--------------------------------");
			System.out.println("Liste des clients: ");
			System.out.println("--------------------------------");
			clients.forEach(cl -> {
				System.out.println("--------------------------------");
				System.out.println("ID: " + cl.getId());
				System.out.println("Nom: " + cl.getNom());
				System.out.println("Email: " + cl.getEmail());
				System.out.println("--------------------------------");
			});

			Stream.of("Credit Immobilier 1", "Credit Immobilier 2", "Credit Immobilier 3").forEach(type -> {
				CreditImmobilier credit = CreditImmobilier.builder()
						.dateDemande(new Date(System.currentTimeMillis()))
						.statut(Status.Accepted)
						.dateAcceptation(new Date(System.currentTimeMillis()))
						.montant(10000.0)
						.dureeRemboursement(12)
						.tauxInteret(0.05)
						.typeBien(Bien.Appartement)
						.client(clients.get(2))
						.build();

				creditImmobilierRepository.save(credit);
			});

			List<CreditImmobilier> creditImmobiliers = creditImmobilierRepository.findAll();
			System.out.println("--------------------------------");
			System.out.println("Liste des crédits immobiliers: ");
			System.out.println("--------------------------------");
			creditImmobiliers.forEach(ci -> {
				System.out.println("--------------------------------");
				System.out.println("ID: " + ci.getId());
				System.out.println("Type de Bien: " + ci.getTypeBien());
				System.out.println("--------------------------------");
			});

			Stream.of("Credit Professionnel 1", "Credit Professionnel 2", "Credit Professionnel 3").forEach(type -> {
				CreditProfessionnel credit = CreditProfessionnel.builder()
						.dateDemande(new Date(System.currentTimeMillis()))
						.statut(Status.Accepted)
						.dateAcceptation(new Date(System.currentTimeMillis()))
						.motif("Motif " + type)
						.raisonSociale("Raison Sociale " + type)
						.client(clients.get(1))
						.build();

				creditProfessionnelRepository.save(credit);
			});

			List<CreditProfessionnel> creditProfessionnels = creditProfessionnelRepository.findAll();
			System.out.println("--------------------------------");
			System.out.println("Liste des crédits professionnels: ");
			System.out.println("--------------------------------");
			creditProfessionnels.forEach(cp -> {
				System.out.println("--------------------------------");
				System.out.println("ID: " + cp.getId());
				System.out.println("Motif: " + cp.getMotif());
				System.out.println("Raison Sociale: " + cp.getRaisonSociale());
				System.out.println("--------------------------------");
			});

			System.out.println("Modification du crédit professionnel 1");
			creditProfessionnelRepository.findById(1L).ifPresent(cp -> {
				cp.setMotif("Motif modifié");
				creditProfessionnelRepository.save(cp);
			});

			System.out.println("Suppression du crédit professionnel 1");
			creditProfessionnelRepository.deleteById(1L);

			System.out.println("Liste des crédits professionnels après suppression: ");
			creditProfessionnels = creditProfessionnelRepository.findAll();

			System.out.println("Ajout d'un nouveau crédit pour un client");
			Client client = clientRepository.findById(1L).orElseThrow(() -> new RuntimeException("Client non trouvé"));

			CreditImmobilier creditImmobilier = CreditImmobilier.builder()
					.dateDemande(new Date(System.currentTimeMillis()))
					.statut(Status.Accepted)
					.dateAcceptation(new Date(System.currentTimeMillis()))
					.montant(10000.0)
					.dureeRemboursement(12)
					.tauxInteret(0.05)
					.typeBien(Bien.Appartement)
					.client(client)
					.build();

			CreditPersonnel creditPersonnel = CreditPersonnel.builder()
					.dateDemande(new Date(System.currentTimeMillis()))
					.statut(Status.Accepted)
					.dateAcceptation(new Date(System.currentTimeMillis()))
					.montant(10000.0)
					.dureeRemboursement(12)
					.tauxInteret(0.05)
					.motif("Motif :" + "Credit Personnel")
					.client(client)
					.build();


			creditPersonnelRepository.save(creditPersonnel);
			creditImmobilierRepository.save(creditImmobilier);

			Remboursement remboursementPersonnel = Remboursement.builder()
					.date(new Date(System.currentTimeMillis()))
					.credit(creditPersonnel)
					.type(Type.Anticipe)
					.montant(10000.0)
					.build();

			Remboursement remboursementImmobilier = Remboursement.builder()
					.date(new Date(System.currentTimeMillis()))
					.credit(creditImmobilier)
					.montant(10000.0)
					.type(Type.Mensualite)
					.build();

			remboursementRepository.save(remboursementPersonnel);
			remboursementRepository.save(remboursementImmobilier);

			creditImmobilier.getRemboursements().add(remboursementImmobilier);
			creditPersonnel.getRemboursements().add(remboursementPersonnel);	

			
			creditPersonnelRepository.save(creditPersonnel);
			creditImmobilierRepository.save(creditImmobilier);

			
			clientRepository.save(client);

			System.out.println("Liste des crédits du client 1 après ajout: ");
			Client clientCredite = clientRepository.findById(1L)
					.orElseThrow(() -> new RuntimeException("Client non trouvé"));

			List<Credit> credits = clientCredite.getCredits();
			credits.forEach(c -> {
				System.out.println("--------------------------------");
				System.out.println("ID: " + c.getId());
				System.out.println("Type de Crédit: " + c.getClass().getSimpleName());
				if (c instanceof CreditImmobilier) {
					System.out.println("Type de Bien: " + ((CreditImmobilier) c).getTypeBien());
				} else if (c instanceof CreditPersonnel) {
					System.out.println("Motif: " + ((CreditPersonnel) c).getMotif());
				} else if (c instanceof CreditProfessionnel) {
					System.out.println("Motif: " + ((CreditProfessionnel) c).getMotif());
					System.out.println("Raison Sociale: " + ((CreditProfessionnel) c).getRaisonSociale());
				}
				System.out.println("--------------------------------");
			});

		};
	}

	@Bean
	CommandLineRunner clientService(ClientRepository clientRepository) {
		return args -> {
			System.out.println("Application ClientService");
			List<Client> clients = clientRepository.findAll();
			clients.forEach(client -> {
				System.out.println("--------------------------------");
				System.out.println("ID: " + client.getId());
				System.out.println("Nom: " + client.getNom());
				List<Credit> credits = client.getCredits();
				credits.forEach(credit -> {
					System.out.println("--------------------------------");
					System.out.println("ID: " + credit.getId());
					System.out.println("Type de Crédit: " + credit.getClass().getSimpleName());
					System.out.println("--------------------------------");
				});
				System.out.println("--------------------------------");
			});

		};
	}
}
