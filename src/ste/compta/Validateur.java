package ste.compta;
import java.util.Iterator;
import ste.compta.compte.Compte;
import ste.compta.compte.ListeComptes;
/**================================================================
 * Classe de validation des entrées de nouveaux numéros de compte
 * Retourne un objet contenant les fields nécessaires à la création 
 * d'un nouvel objet de type CompteGeneral ou CompteParticulier
 *-----------------------------------------------------------------*/
public class Validateur {
	private boolean gen = false;
	private boolean sub = false;
	private String uid = null;
	private String label = null;
	private boolean isValid=true;


	public Validateur(boolean gen, boolean sub, String uid, String label){
		int length = uid.length();
		boolean isValid = true;
		/**===============================
		 *  Vérification de non nullité 
		 *  valide si :
		 *  - N'est pas null
		 *  - Contient au moins un chiffre
		 *--------------------------------*/
		isValid = (label != null);
		if(isValid)
			isValid = uid.matches("^[0-9]*$");

		/**===============================================================
		 * Vérification de longueur sur le type Général
		 *  valide si :
		 *  - est subdivisible 
		 *    et sa longueur est de moins de 6
		 *  - est non subdivisible
		 *    => si la longueur est de 5 ou moins, ajout de trailing zeros
		 *----------------------------------------------------------------*/
		if(isValid && gen){
			if (isValid && sub)
				if (length <= 6)
					while (uid.length() <6)
						uid = uid+"0";
				else
					isValid = false;
			/**==============================================================
			 * Vérification de longueur sur le type Particulier
			 *  valide si :
			 *  - est subdivisible 
			 *    et sa longueur est de MAX 10
			 *  - est non subdivisible
			 *    => si la longueur est de 9 ou moins, ajout de trailing zeros
			 *----------------------------------------------------------------*/
		}else{
			if (isValid && sub)
				if (length <= 9) 
					while (uid.length() <9)
						uid = uid+"0";
				else 
					isValid = false;
		}

		/**========================================================
		 * Vérification de l'unicité du Compte dans la liste globale
		 *----------------------------------------------------------*/
		if(isValid)
			for (Iterator<Compte> i = ListeComptes.listeComptes.iterator(); i.hasNext();) {
				Compte c = i.next();
				if (c.getUID().equals(uid)) {
					isValid = false;
				}
			}

		/**=======================================================
		 * Assignation des valeurs recalculées à l'objet Validateur
		 * pour transmission au constructeur appelé par la Fabrique
		 *---------------------------------------------------------*/
		if(isValid){
			this.gen = gen;
			this.sub = sub;
			this.uid = uid;
			this.label = label;
			this.isValid = isValid;
		}else{
			this.isValid = false;
		}
	}

	public boolean isGen() {
		return gen;
	}

	public boolean isSub() {
		return sub;
	}

	public String getUid() {
		return uid;
	}

	public String getLabel() {
		return label;
	}

	public boolean isValid() {
		return this.isValid;
	}

	public char getPositionBilan() {
		return PositionBilan.A.charOf();
	}
}
