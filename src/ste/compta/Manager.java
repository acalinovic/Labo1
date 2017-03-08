package ste.compta;

import ste.compta.compte.Compte;
import ste.compta.compte.ListeComptes;

public class Manager {

	public static void main(String[] args) {
		FabriqueCompte fc = new FabriqueCompte();
		Compte current = fc.buildCompte(true,true,"1","Compte Général Racine");
		if (current != null)
			ListeComptes.listeComptes.add(current);
		if(ListeComptes.listeComptes.size() >= 1){
			System.out.println(ListeComptes.getCompte(current).toString());
		}
		current = fc.buildCompte(false,false,"1","Compte Général Fils");
		if (current != null)
			ListeComptes.listeComptes.add(current);
		if(ListeComptes.listeComptes.size() >= 2){
			System.out.println(ListeComptes.getCompte(current).toString());
		}
	}
}

