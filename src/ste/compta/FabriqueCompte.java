package ste.compta;
import ste.compta.compte.Compte;
import ste.compta.compte.CompteGeneral;
import ste.compta.compte.CompteParticulier;
/**================================================================
 * Classe de Fabrique de Comptes
 * Prends les paramètres nécessaires à la validation et
 * la création d'un nouvel objet CompteGeneral ou Compte Particulier
 * (en fonction du booléen 'gen' pour Général
 *------------------------------------------------------------------*/
public class FabriqueCompte {
	public Compte buildCompte(boolean gen, boolean sub, String uid, String label){
		/**=================================
		 * Builder, prenant comme paramètres:
		 * type général true|false
		 * type subdivisible true|false
		 * numéro de compte demandé
		 * libellé du compte
		 *-----------------------------------*/
		Validateur v = new Validateur(gen,sub,uid,label);
		if(v.isValid()){
			if(gen)
				return new CompteGeneral(v);
			else
				return new CompteParticulier(v);
		}else{
			System.out.println("Compte invalide :: Impossible de le créer");
			return null;
		}	
	}
}
