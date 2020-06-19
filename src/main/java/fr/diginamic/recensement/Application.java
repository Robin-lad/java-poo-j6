package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.services.RechercheException;
import fr.diginamic.recensement.services.RecherchePopulationBorneService;
import fr.diginamic.recensement.services.RecherchePopulationDepartementService;
import fr.diginamic.recensement.services.RecherchePopulationRegionService;
import fr.diginamic.recensement.services.RecherchePopulationVilleService;
import fr.diginamic.recensement.utils.RecensementUtils;

/**
 * Application de traitement des donn�es de recensement de population
 * 
 * @param args
 */
public class Application {

	/**
	 * Point d'entr�e
	 * 
	 * @param args arguments (non utilis� ici)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String filePath = ClassLoader.getSystemClassLoader().getResource("recensement.csv").getFile();
		Recensement recensement = RecensementUtils.lire(filePath);

		if (recensement == null) {
			System.out.println("L'application doit s'arretter en raison d'une erreur d'ex�cution.");
			System.exit(0);
		}

		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question � l'utilisateur
			String choixMenu = scanner.nextLine();

			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);

			// On ex�cute l'option correspondant au choix de l'utilisateur
			switch (choix) {
			case 1:
				RecherchePopulationVilleService rechercheVille = new RecherchePopulationVilleService();
				try {
					rechercheVille.traiter(recensement, scanner);
				} catch (RechercheException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				RecherchePopulationDepartementService rechercheDept = new RecherchePopulationDepartementService();
				try {
					rechercheDept.traiter(recensement, scanner);
				} catch (RechercheException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				RecherchePopulationRegionService rechercheRegion = new RecherchePopulationRegionService();
				try {
					rechercheRegion.traiter(recensement, scanner);
				} catch (RechercheException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				RecherchePopulationBorneService recherchePopBorne = new RecherchePopulationBorneService();
				try {
					recherchePopBorne.traiter(recensement, scanner);
				} catch (NumberFormatException e) {
					System.err.println("Veuillez entrer des chiffres.");
				} catch (RechercheException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
		} while (choix != 99);

		scanner.close();

	}

	/**
	 * Affichage du menu
	 */
	private static void afficherMenu() {
		System.out.println("***** Recensement population *****");
		System.out.println("1. Rechercher la population d'une ville");
		System.out.println("2. Rechercher la population d'un d�partement");
		System.out.println("3. Rechercher la population d'une r�gion");
		System.out.println("4. Rechercher la population des villes d'un dept entre min et max");
		System.out.println("99. Sortir");
	}
}
