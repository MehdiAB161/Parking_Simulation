package partie2.application;
import java.util.ArrayList;

import partie2.utilLocalisation.Localisation;

public	class	 ServiceInformation { 
	private MesParcmetres 	parcmetres	;

	public	 ServiceInformation() {
		parcmetres = new MesParcmetres();
	}

	// ajoute un nouveau parcmètre à l’arrayList 
	public	void	 enregistrer(Parcmetre parcmetre)  {
		parcmetres.ajouterElement(parcmetre);
	}

	// retourne le 	Parcmètre	 le plus proche de la localisation l 
	public	 Parcmetre getParcmetre(Localisation l) {
		double min =150; //Deux points du plan sont toujours à une distance inferieur à 150
		// Donc la fonction ne renverra jamais un "null" 
		int xi=0,yi=0;
		int x = l.getx();
		int y = l.gety();
		double d=0;
		int p=0;

		for(int i=0; i<parcmetres.nombreElement();i++){
			xi = parcmetres.getParcmetre(i).getposition().getx();
			yi = parcmetres.getParcmetre(i).getposition().gety();
			d = Math.sqrt((xi-x)*(xi-x) +(yi-y)*(yi-y));
			if(d < min ){
				min =d;
				p=i;
			}
		}//On cherche le parcmetre le plus proche de la Localisation l
		return parcmetres.getParcmetre(p);		
	}


	//La fonction libreplusroche n'est pas utilisé

	// retourne tous les parcmètres dont la distance à 	l est inférieure à distance. 	@SuppressWarnings("null")
	public	 ArrayList<Parcmetre> libreplusProche(Localisation 	l, 	int	 distance) {


		ArrayList <Parcmetre> liste = new ArrayList<Parcmetre>(); 

		for(int i=0; i<parcmetres.nombreElement(); i++){

			if( l.isProche(parcmetres.getParcmetre(i).getposition(), distance) & parcmetres.getParcmetre(i).isOccupee() ){
				liste.add(parcmetres.getParcmetre(i));


			}//pas utilisé 	
		}
		return liste;
	}


	public MesParcmetres getparcmetres()
	{
		return parcmetres;
	}//On a besoin de retourner la liste des parcmetres du Service d'information(A ne pas confondre avec getParcmetre() méthode de la classe Parcmetre ): 
	// Dans vehicule simule lorsque l'on a besoin de réorienter un vehicule arès que son ParcmetreDestination à été occupé
}

