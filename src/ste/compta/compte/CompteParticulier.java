package ste.compta.compte;

import ste.compta.Validateur;

public class CompteParticulier extends Compte {
	private CompteGeneral cg;
	public CompteParticulier(Validateur v) {
		this.UID = v.getUid();
		this.label = v.getLabel();
		this.sub = v.isSub();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cg == null) ? 0 : cg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompteParticulier other = (CompteParticulier) obj;
		if (cg == null) {
			if (other.cg != null)
				return false;
		} else if (!cg.equals(other.cg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompteParticulier [cg=" + cg + ", UID=" + UID + ", label=" + label + ", sub=" + sub + ", parent="+getParent()+"]";
	}
}
