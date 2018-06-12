package com.mmonsoor;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
	
	// On définit l'id de l'étudiant qui s'incrémente
	private static int idetudiants = 0;
	// On définit une liste d'étudiants en mode TreeMap key=id et valeur (un
	// tableau)
	private static TreeMap<Integer, Object[]> listeetudiantsstatic = new TreeMap();
	private static Scanner clavier = new Scanner(System.in);
	public static void displayMenu() {

		// Afficher l'aide du logiciel
		System.out.println("Bienvenu dans le logiciel d'ajout d'étudiants");
		System.out.println("Si vous voulez ajouter un étudiant: Taper a et entrée");
		System.out.println("Si vous voulez supprimer un étudiant: Taper s et entrée");
		System.out.println("Si vous voulez modifier les informations d'un étudiant: Taper m et entrée");
		System.out.println("Si vous voulez faire l'appel: Taper f et entrée");
		System.out.println("Si vous voulez quitter le program: Taper q et entrée");
		System.out.println("Si vous voulez voir la liste des étudiants: Taper v et entrée");
		//Appelle à la fonction userChoice qui va faire des actions en fonction du paramètre entré
		// Boucle infinie tant que le user n'appuie pas sur Quit
		byte infini = 0;
		while (infini == 0) {
			userChoice();
		}
	}

	/**
	 * Demande le choix à l'utilisateur
	 */
	private static void userChoice() {
		// TODO Auto-generated method stub
		//Scanner clavier = new Scanner(System.in);
		// Création d'une TreeMap qui va contenir toutes les données clés valeurs key=id
		// et valeur tableau [Nom,Prénom,date de naissance]
		TreeMap listeEtudiants = new TreeMap();

		boolean verificateur = false;
		// On teste si la lettre est dans la liste autorisée des paramètres
		do {
			System.out.println("Que voulez vous faire. Taper une lettre [a|s|m|f|q|v]");
			// On saisit le choix de l'utilisateur
			String choixUtilisateur = clavier.next();
			// Si la lettre ne fait pas partie des paramètres autorisés
			if ((!choixUtilisateur.equals("a")) && (!choixUtilisateur.equals("s")) && (!choixUtilisateur.equals("m"))
					&& (!choixUtilisateur.equals("f")) && (!choixUtilisateur.equals("q"))&& (!choixUtilisateur.equals("v"))) {
				System.out.println(
						"Vous avez tapé un paramètre qui n'existe pas, veuillez retaper une lettre [a|s|m|f|q|v] ");

			}
			// L'utilisateur a entré un bon paramètre, on va pouvoir faire appelle à des
			// fonctions
			else {
				verificateur = true;
				// L'utilisateur veut rentrer un étudiant
				if (choixUtilisateur.equals("a")) {
					//System.out.println("Appelle à la fonction Ajouter Etudiant");
					addStudent();
				}
				// L'utilisateur veut rentrer un étudiant
				if (choixUtilisateur.equals("s")) {
					//On montre d'abord la liste d'étudiants à l'utilisateur
					showStudentList();
					//System.out.println("Appelle à la fonction Supprimer Etudiant");
					removeStudent();
				}
				// L'utilisateur veut supprimer un étudiant
				if (choixUtilisateur.equals("q")) {
					//System.out.println("Appelle à la fonction Ajouter Etudiant");
					Object o[]=(Object[]) listeetudiantsstatic.get(1);
					String prenom1=(String)o[1];
					Object o2[]=(Object[]) listeetudiantsstatic.get(2);
					System.exit(0);
				}
				// L'utilisateur veut modifier les attributs d'un étudiant
				if (choixUtilisateur.equals("m")) {
					//On montre d'abord la liste d'étudiants à l'utilisateur
					showStudentList();
					modifyStudent();
				}
				// L'utilisateur veut modifier les attributs d'un étudiant
				if (choixUtilisateur.equals("v")) {
					//System.out.println("Appelle à la fonction voirlisteétudiants");
					showStudentList();
				}
			}

		} while (verificateur != true);
	}
	/**
	 * On va afficher toute la liste des étudiants aver leur attributs
	 */
	private static void showStudentList() {
		// TODO Auto-generated method stub
		//On énumère les clés de la TreeMap et on récupère chaque id des étudiants
		if(!listeetudiantsstatic.keySet().isEmpty()) {
			for (Object key : listeetudiantsstatic.keySet()) {
				//On récupère les valeurs des clés, donc un tableau d'object contenant tous les attributs de chaque étudiant
				Object [] attributEtudiant=(Object[]) listeetudiantsstatic.get(key);
				//On parcours le tableau d'objet pour afficher chaque attribut
				System.out.println("["+key+"] "+((String) attributEtudiant[0]).toUpperCase()+" "+(String) attributEtudiant[1]+" "+(String) attributEtudiant[2]+" Âge: "+(Byte) attributEtudiant[3]+"ans");
			}		
		}
		else {
			System.out.println("Il n'y a pas d'étudiants à afficher. Vous devez rentrer au  moins un étudiant, taper la lettre a.");
		}
		
		
	}

	private static void modifyStudent() {
		// TODO Auto-generated method stub
		System.out.println("Indiquer l'identifiant de l'étudiant dont vous voulez modifier les attributs");
		int idetudiant=clavier.nextInt();
		//On va récupérer un par un les attributs
		Object attributs[]=(Object[]) listeetudiantsstatic.get(idetudiant);
		//GESTION DES ATTRIBUTS
		System.out.println("Voulez vous modifier le nom de l'étudiant? Si oui rentrer la nouvelle donnée, sinon appuyer sur entrée: "+(String)attributs[0]);
		String keepName=checkKeepAttribut(attributs,0);
		System.out.println("0");
		System.out.println("Voulez vous modifier le prénom de l'étudiant? Si oui rentrer la nouvelle donnée, sinon appuyer sur entrée: "+(String)attributs[1]);
		String keepFirstName=checkKeepAttribut(attributs,1);	
		System.out.println("Voulez vous modifier la date de naissance de l'étudiant? Si oui rentrer la nouvelle donnée, sinon appuyer sur entrée: "+(String)attributs[2]);
		String keepDateofBirth=checkKeepAttribut(attributs,2);
		//On récupère l'âge calculé de l'étudiant
		Byte keepAge=Etudiant.recupererAge(keepDateofBirth);
		//On récupère tout dans un nouveau tableau
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
		System.out.println("Si vous voulez supprimer un étudiant, indiquer son identifiant");
		idetudiant=clavier.nextInt();
		//On va supprimer l'étudiant avec son identifiant unique
		listeetudiantsstatic.remove(idetudiant);
		System.out.println("L'étudiant avec l'identifiant "+idetudiant+" a été supprimé de la base de données");
	}

	/**
	 * Fonction qui ajoute un étudiant
	 */
	private static void addStudent() {
		String Nom;
		String prénom;
		String date_naissance;
		Byte age;
		//Scanner clavier = new Scanner(System.in);
		idetudiants++;
		// On récupère le nom de l'étudiant
		Nom = Etudiant.recupererNom(clavier);
		// On récupère le prénom de l'étudiant
		prénom = Etudiant.recupererPrenom(clavier);
		// On récupère la date de naissance
		date_naissance = Etudiant.recupererDateNaissance(clavier);
		// On récupère l'âge de l'étudiant
		age = Etudiant.recupererAge(date_naissance);
		//On crée un tableau qui va contenir les attributs de l'étudiant
		Object [] attributEtudiants =new Object[]{Nom,prénom,date_naissance,age};
		System.out.println(attributEtudiants[0]+" "+attributEtudiants[1]+" "+attributEtudiants[2]+" "+attributEtudiants[3]);
		// On ajoute l'étudiant
		listeetudiantsstatic.put(idetudiants,attributEtudiants);
		//Demander à l'utilisateur s'il veut ajouter un autre étudiant
		//System.out.println("Voulez ajouter un autre étudiant?");
	}
}
