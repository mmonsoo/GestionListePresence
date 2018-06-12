package com.mmonsoor;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
	
	// On d�finit l'id de l'�tudiant qui s'incr�mente
	private static int idetudiants = 0;
	// On d�finit une liste d'�tudiants en mode TreeMap key=id et valeur (un
	// tableau)
	private static TreeMap<Integer, Object[]> listeetudiantsstatic = new TreeMap();
	private static Scanner clavier = new Scanner(System.in);
	public static void displayMenu() {

		// Afficher l'aide du logiciel
		System.out.println("Bienvenu dans le logiciel d'ajout d'�tudiants");
		System.out.println("Si vous voulez ajouter un �tudiant: Taper a et entr�e");
		System.out.println("Si vous voulez supprimer un �tudiant: Taper s et entr�e");
		System.out.println("Si vous voulez modifier les informations d'un �tudiant: Taper m et entr�e");
		System.out.println("Si vous voulez faire l'appel: Taper f et entr�e");
		System.out.println("Si vous voulez quitter le program: Taper q et entr�e");
		System.out.println("Si vous voulez voir la liste des �tudiants: Taper v et entr�e");
		//Appelle � la fonction userChoice qui va faire des actions en fonction du param�tre entr�
		// Boucle infinie tant que le user n'appuie pas sur Quit
		byte infini = 0;
		while (infini == 0) {
			userChoice();
		}
	}

	/**
	 * Demande le choix � l'utilisateur
	 */
	private static void userChoice() {
		// TODO Auto-generated method stub
		//Scanner clavier = new Scanner(System.in);
		// Cr�ation d'une TreeMap qui va contenir toutes les donn�es cl�s valeurs key=id
		// et valeur tableau [Nom,Pr�nom,date de naissance]
		TreeMap listeEtudiants = new TreeMap();

		boolean verificateur = false;
		// On teste si la lettre est dans la liste autoris�e des param�tres
		do {
			System.out.println("Que voulez vous faire. Taper une lettre [a|s|m|f|q|v]");
			// On saisit le choix de l'utilisateur
			String choixUtilisateur = clavier.next();
			// Si la lettre ne fait pas partie des param�tres autoris�s
			if ((!choixUtilisateur.equals("a")) && (!choixUtilisateur.equals("s")) && (!choixUtilisateur.equals("m"))
					&& (!choixUtilisateur.equals("f")) && (!choixUtilisateur.equals("q"))&& (!choixUtilisateur.equals("v"))) {
				System.out.println(
						"Vous avez tap� un param�tre qui n'existe pas, veuillez retaper une lettre [a|s|m|f|q|v] ");

			}
			// L'utilisateur a entr� un bon param�tre, on va pouvoir faire appelle � des
			// fonctions
			else {
				verificateur = true;
				// L'utilisateur veut rentrer un �tudiant
				if (choixUtilisateur.equals("a")) {
					//System.out.println("Appelle � la fonction Ajouter Etudiant");
					addStudent();
				}
				// L'utilisateur veut rentrer un �tudiant
				if (choixUtilisateur.equals("s")) {
					//On montre d'abord la liste d'�tudiants � l'utilisateur
					showStudentList();
					//System.out.println("Appelle � la fonction Supprimer Etudiant");
					removeStudent();
				}
				// L'utilisateur veut supprimer un �tudiant
				if (choixUtilisateur.equals("q")) {
					//System.out.println("Appelle � la fonction Ajouter Etudiant");
					Object o[]=(Object[]) listeetudiantsstatic.get(1);
					String prenom1=(String)o[1];
					Object o2[]=(Object[]) listeetudiantsstatic.get(2);
					System.exit(0);
				}
				// L'utilisateur veut modifier les attributs d'un �tudiant
				if (choixUtilisateur.equals("m")) {
					//On montre d'abord la liste d'�tudiants � l'utilisateur
					showStudentList();
					modifyStudent();
				}
				// L'utilisateur veut modifier les attributs d'un �tudiant
				if (choixUtilisateur.equals("v")) {
					//System.out.println("Appelle � la fonction voirliste�tudiants");
					showStudentList();
				}
			}

		} while (verificateur != true);
	}
	/**
	 * On va afficher toute la liste des �tudiants aver leur attributs
	 */
	private static void showStudentList() {
		// TODO Auto-generated method stub
		//On �num�re les cl�s de la TreeMap et on r�cup�re chaque id des �tudiants
		if(!listeetudiantsstatic.keySet().isEmpty()) {
			for (Object key : listeetudiantsstatic.keySet()) {
				//On r�cup�re les valeurs des cl�s, donc un tableau d'object contenant tous les attributs de chaque �tudiant
				Object [] attributEtudiant=(Object[]) listeetudiantsstatic.get(key);
				//On parcours le tableau d'objet pour afficher chaque attribut
				System.out.println("["+key+"] "+((String) attributEtudiant[0]).toUpperCase()+" "+(String) attributEtudiant[1]+" "+(String) attributEtudiant[2]+" �ge: "+(Byte) attributEtudiant[3]+"ans");
			}		
		}
		else {
			System.out.println("Il n'y a pas d'�tudiants � afficher. Vous devez rentrer au  moins un �tudiant, taper la lettre a.");
		}
		
		
	}

	private static void modifyStudent() {
		// TODO Auto-generated method stub
		System.out.println("Indiquer l'identifiant de l'�tudiant dont vous voulez modifier les attributs");
		int idetudiant=clavier.nextInt();
		//On va r�cup�rer un par un les attributs
		Object attributs[]=(Object[]) listeetudiantsstatic.get(idetudiant);
		//GESTION DES ATTRIBUTS
		System.out.println("Voulez vous modifier le nom de l'�tudiant? Si oui rentrer la nouvelle donn�e, sinon appuyer sur entr�e: "+(String)attributs[0]);
		String keepName=checkKeepAttribut(attributs,0);
		System.out.println("0");
		System.out.println("Voulez vous modifier le pr�nom de l'�tudiant? Si oui rentrer la nouvelle donn�e, sinon appuyer sur entr�e: "+(String)attributs[1]);
		String keepFirstName=checkKeepAttribut(attributs,1);	
		System.out.println("Voulez vous modifier la date de naissance de l'�tudiant? Si oui rentrer la nouvelle donn�e, sinon appuyer sur entr�e: "+(String)attributs[2]);
		String keepDateofBirth=checkKeepAttribut(attributs,2);
		//On r�cup�re l'�ge calcul� de l'�tudiant
		Byte keepAge=Etudiant.recupererAge(keepDateofBirth);
		//On r�cup�re tout dans un nouveau tableau
		Object [] keepAllAttributs= {keepName,keepFirstName,keepDateofBirth,keepAge};
		//On modifie les nouvelles valeurs
		listeetudiantsstatic.replace(idetudiant, keepAllAttributs);	
	}

	/**
	 * @param clavier
	 * @param attributs
	 */
	private static String checkKeepAttribut(Object[] attributs,int index) {
		System.out.println("1");
		Scanner keyboard=new Scanner(System.in);
		String saisiNouveauNom=keyboard.nextLine();
		String nomAGarder;
		if (saisiNouveauNom.isEmpty()) {
			nomAGarder=(String)attributs[index];	
		}
		else {
			nomAGarder=saisiNouveauNom;
		}
		System.out.println("2");
		return nomAGarder;
	}
	private static void removeStudent() {
		// TODO Auto-generated method stub
		int idetudiant;
		//Scanner clavier = new Scanner(System.in);
		System.out.println("Si vous voulez supprimer un �tudiant, indiquer son identifiant");
		idetudiant=clavier.nextInt();
		//On va supprimer l'�tudiant avec son identifiant unique
		listeetudiantsstatic.remove(idetudiant);
		System.out.println("L'�tudiant avec l'identifiant "+idetudiant+" a �t� supprim� de la base de donn�es");
	}

	/**
	 * Fonction qui ajoute un �tudiant
	 */
	private static void addStudent() {
		String Nom;
		String pr�nom;
		String date_naissance;
		Byte age;
		//Scanner clavier = new Scanner(System.in);
		idetudiants++;
		// On r�cup�re le nom de l'�tudiant
		Nom = Etudiant.recupererNom(clavier);
		// On r�cup�re le pr�nom de l'�tudiant
		pr�nom = Etudiant.recupererPrenom(clavier);
		// On r�cup�re la date de naissance
		date_naissance = Etudiant.recupererDateNaissance(clavier);
		// On r�cup�re l'�ge de l'�tudiant
		age = Etudiant.recupererAge(date_naissance);
		//On cr�e un tableau qui va contenir les attributs de l'�tudiant
		Object [] attributEtudiants =new Object[]{Nom,pr�nom,date_naissance,age};
		System.out.println(attributEtudiants[0]+" "+attributEtudiants[1]+" "+attributEtudiants[2]+" "+attributEtudiants[3]);
		// On ajoute l'�tudiant
		listeetudiantsstatic.put(idetudiants,attributEtudiants);
		//Demander � l'utilisateur s'il veut ajouter un autre �tudiant
		//System.out.println("Voulez ajouter un autre �tudiant?");
	}
}
