package com.mmonsoor;

import java.util.Scanner;

public class Etudiant {

	
	static public String recupererNom(Scanner claviercopie) {
		//V�rifier qu'un nom est bien �crit
		boolean verificateur= false;
		String lastName;
		//On doit au moins rentrer une fois dans la boucle
		do {
			System.out.println("Entrer le nom de l'�tudiant: ");
			lastName=claviercopie.nextLine();
			verificateur=lastName.chars().allMatch(Character::isLetter);
			if((lastName.length()>=3) && (verificateur==true)) {
				//System.out.println("Le nom de l'�tudiant est correcte");
				verificateur=true;
			}
			else {
				System.out.println("Le nom de l'�tudiant n'est pas correcte");
				verificateur=false;
			}		
		}
		while(verificateur!=true);
		
		return lastName;
		
	}
	
	
	static String recupererPrenom(Scanner claviercopie) {
		//V�rifier qu'un pr�nom est bien �crit
		boolean verificateur= false;
		String firstName;
		//On doit au moins rentrer une fois dans la boucle
		do {
			System.out.println("Entrer le pr�nom de l'�tudiant: ");
			firstName=claviercopie.nextLine();
			verificateur=firstName.chars().allMatch(Character::isLetter);
			if((firstName.length()>=3) && (verificateur==true)) {
				//System.out.println("Le pr�nom de l'�tudiant est correcte");
				verificateur=true;
			}
			else {
				System.out.println("Le pr�nom de l'�tudiant n'est pas correcte");
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
		System.out.println("Entrer la date de naissance de l'�tudiant sous format JJ/MM/AAAA : ");
		String firstName;
		firstName=claviercopie.nextLine();
		return firstName;
		
		
	}
	
}
