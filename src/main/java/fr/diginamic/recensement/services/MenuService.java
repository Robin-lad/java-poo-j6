package fr.diginamic.recensement.services;

import java.io.IOException;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * M�thode abstraite de traitement que doivent posseder toutes les m�thodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws IOException
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws RechercheException, NumberFormatException;
}
