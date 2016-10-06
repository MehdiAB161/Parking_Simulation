package partie2.application;

import java.util.ArrayList;

import partie2.utilLocalisation.Localisation;
import partie2.utilLocalisation.MesSitues;

public class MesParcmetres extends MesSitues<Parcmetre> {

	public void afficherDispo() {
		IteratorLibre IT=new IteratorLibre(this);
		while(IT.hasNext()){
			System.out.println(" "+IT.next().getposition());
		}
	}// affiche seulement les Parcmetres libre grace a IteratorLibre. 


	public ArrayList<Parcmetre> lesParcmetresLibres(Localisation l, int d){

		ArrayList<Parcmetre> mpordonnee=new ArrayList<Parcmetre>();
		ArrayList<Parcmetre> tabLibre=(ArrayList<Parcmetre>) plusProche(l);

		mpordonnee=(ArrayList<Parcmetre>) plusProche(l);
		for(int i=0;i<=nombreElement()-1;i++){
			if(((mpordonnee.get(i)).getposition().distance(l)<=d))
			{
				tabLibre.add(mpordonnee.get(i));

			}
			else
				i=nombreElement();
		}
		return tabLibre;
	} // Cette fonciton ne sert plus. 
	//retourne les Parcmetres libres � une distance inferieure � d
	// la liste est ordonn�e du plus proche au plus lointain en utilisant la
	//m�thode }

	public Parcmetre getParcmetre(int i){
		// retourne le ieme Parcmetre, l'�l�ment courant et recherche le suivant.
		return getElementSitue(i);
	}
}