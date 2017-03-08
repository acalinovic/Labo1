package ste.compta.compte;

import java.util.HashSet;
import java.util.Iterator;

public class ListeComptes {
	public static HashSet<Compte> listeComptes = new HashSet<>();
	public HashSet<Compte> getListeComptes(){
		return listeComptes;
	}

	public static Compte getCompte(String uid){
		for (Iterator<Compte> i = listeComptes.iterator(); i.hasNext();) {
			Compte c = i.next();
			if (c.getUID() == uid) return c;
		}
		return null;
	}
	public static Compte getCompte(Compte compte){
		for (Iterator<Compte> i = listeComptes.iterator(); i.hasNext();) {
			Compte c = i.next();
			if (c.equals(compte)) return c;
		}
		return null;
	}
}
