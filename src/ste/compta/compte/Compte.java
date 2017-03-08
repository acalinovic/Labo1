package ste.compta.compte;

import java.util.HashSet;
import java.util.Iterator;

import ste.compta.compte.*;
import ste.compta.ecriture.Ecriture;

public abstract class Compte {
	private HashSet<Ecriture> journal = new HashSet<>();
	private Compte parent;
	protected String UID;
	protected String label;
	protected boolean sub;
	
	public String getUID(){
		return UID;
	}
	public String getLabel(){
		return label;
	}
	public boolean getSub(){
		return sub;
	}
	
	
	public HashSet<Ecriture> getJournal() {
		return journal;
	}
	public Compte getParent() {
		return parent;
	}
	public void setParent() {
		Compte parent=null;
		
		for (Iterator<Compte> i = ListeComptes.listeComptes.iterator(); i.hasNext();) {
			Compte compte = i.next();
			String regex = "^("+UID+")";
			if (compte.UID.matches("^"))
				this.parent = parent;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UID == null) ? 0 : UID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (UID == null) {
			if (other.UID != null)
				return false;
		} else if (!UID.equals(other.UID))
			return false;
		return true;
	}
	
	
}
