package ste.compta.compte;
import ste.compta.Validateur;
public class CompteGeneral extends Compte {
	private char positionBilan;

	public CompteGeneral(Validateur v) {
		this.UID = v.getUid();
		this.label = v.getLabel();
		this.sub = v.isSub();
		this.positionBilan = v.getPositionBilan();
	}
		
	public void setPositionBilan(char pb){
		this.positionBilan = pb;
	}
	public void setUID(String uid){
		 this.UID = uid;
	}
	public void setLabel(String label){
		 this.label = label;
	}
	
	public char getPositionBilan(){
		return positionBilan;
	}
	public String getUID(){
		return UID;
	}
	public String getLabel(){
		return label;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + positionBilan;
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
		CompteGeneral other = (CompteGeneral) obj;
		if (positionBilan != other.positionBilan)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompteGeneral [positionBilan=" + positionBilan + ", UID=" + UID + ", label=" + label + ", sub=" + sub + ", parent="+getParent()+"]";
	}
}
