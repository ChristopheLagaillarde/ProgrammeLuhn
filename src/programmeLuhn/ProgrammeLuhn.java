/*/////////////////En t�te////////////////////////////
 * Programme : Programme v�rifier carte bancaire.
 *
 * Description : Ce programme v�rifie si le num�ro 
 *               d'une carte bancaire est valide ou
 *               pas gr�ce � l'algorithme de Luhn.
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 10/05/2021
 *        
 *///////////////////////////////////////////////////

// D�claration des bibliotheques de fonctions...
package programmeLuhn;

import java.util.Scanner;

//////////////////Le Programme principal/////////////

//////////////////D�but//////////////////////////////
public class ProgrammeLuhn {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numeroDeCarte;
		numeroDeCarte = "";
		int cleDeLuhn;
		int somme = 0;
		String chiffresDePlaceImpaire = new String("");
		int i;
		
		while(numeroDeCarte.length() != 16) {
			System.out.println("Veillez entrer le num�ro de carte bancaire � v�rifier(sans les espaces)");
			@SuppressWarnings("resource")
			Scanner saisieUtilisateur = new Scanner(System.in);
			numeroDeCarte = saisieUtilisateur.nextLine();
		}
		cleDeLuhn = Integer.parseInt(numeroDeCarte.substring(numeroDeCarte.length() - 1, numeroDeCarte.length()));

		for(i = 0; i < numeroDeCarte.length(); i++) {
			if(i % 2 ==0) {
				chiffresDePlaceImpaire += numeroDeCarte.substring(i, i + 1);
			}
			else {
				somme += Integer.parseInt(numeroDeCarte.substring(i, i + 1));
			}
		}
		
		int[] tableauChiffresDePlaceImpaire = {0,0,0,0,0,0,0,0};

		for(i = 0; i < 8; i++) {
			tableauChiffresDePlaceImpaire[i] = Character.getNumericValue(chiffresDePlaceImpaire.charAt(i));
		} 

		for(i = 0; i < 8; i++) {
			tableauChiffresDePlaceImpaire[i] = tableauChiffresDePlaceImpaire[i] * 2;		 //5426856712344589
			if(tableauChiffresDePlaceImpaire[i] > 9) {
				tableauChiffresDePlaceImpaire[i] = tableauChiffresDePlaceImpaire[i] - 9;
			}
		}
		
		for(i = 0; i < 8; i++) {
			somme += tableauChiffresDePlaceImpaire[i];
		}

		if((somme % 10) == 0) {
			System.out.println("La cl�e de Luhn " + cleDeLuhn +" est valide.\n"
					+ "Car le reste vaux" + (somme % 10)
					+ "\nCe num�ro de carte est donc valide");
		}
		
		else {
			System.out.println("La cl�e de Luhn " + cleDeLuhn +" n'est pas valide.\n"
					+ "Ce num�ro de carte n'est donc pas valide.\n"
					+ "Car le reste vaux " + (somme % 10)
					+ "\nLa cl�e de Luhn valide est " + (10 - (somme % 10)));
		}
		
	}

}