package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws RechercheException {

		System.out.println("Quel est le nom de la ville recherch�e ? ");
		String choix = scanner.nextLine();

		boolean trouve = false;
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				trouve = true;
				System.out.println(ville);
			}
		}
		if (!trouve) {
			throw new RechercheException("Cette ville n'existe pas.");
		}
	}

}
