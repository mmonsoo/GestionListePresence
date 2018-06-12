package com.mmonsoor;

import java.util.Scanner;

public class Etudiant {

	
	static public String recupererNom(Scanner claviercopie) {
		//Vérifier qu'un nom est bien écrit
		boolean verificateur= false;
		String lastName;
		//On doit au moins rentrer une fois dans la boucle
		do {
			System.out.println("Entrer le nom de l'étudiant: ");
			lastName=claviercopie.nextLine();
			verificateur=lastName.chars().allMatch(Character::isLetter);
			if((lastName.length()>=3) && (verificateur==true)) {
				//System.out.println("Le nom de l'étudiant est correcte");
				verificateur=true;
			}
			else {
				System.out.println("Le nom de l'étudiant n'est pas correcte");
				verificateur=false;
			}		
		}
		while(verificateur!=true);
		
		return lastName;
		
	}
	
	
	static String recupererPrenom(Scanner claviercopie) {
		//Vérifier qu'un prénom est bien écrit
		boolean verificateur= false;
		String firstName;
		//On doit au moins rentrer une fois dans la boucle
		do {
			System.out.println("Entrer le prénom de l'étudiant: ");
			firstName=claviercopie.nextLine();
			verificateur=firstName.chars().allMatch(Character::isLetter);
			if((firstName.length()>=3) && (verificateur==true)) {
				//System.out.println("Le prénom de l'étudiant est correcte");
				verificateur=true;
			}
			else {
				System.out.println("Le prénom de l'étudiant n'est pas correcte");
				verificateur=false;
			}
			
		}
		while(verificateur!=true);
		
		return firstName;
		
	}
	
	static Byte recupererAge(String dateNaissance) {
		String agee;
		String [] ageetab;
		//On doit au moins rentrer une fois dans la boucle
			ageetab=dateNaissance.split("/");
			//System.out.println(ageetab[2]);
		return (byte) (2018-Short.parseShort(ageetab[2]));
		
	}
	
	static String recupererDateNaissance(Scanner claviercopie) {
		System.out.println("Entrer la date de naissance de l'étudiant sous format JJ/MM/AAAA : ");
		String firstName;
		firstName=claviercopie.nextLine();
		return firstName;
		
		
	}
	
}
