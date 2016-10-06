package partie1.application;

import java.util.ArrayList;

public class ServiceInformation {
	ArrayList <Parcmetre> parcmetres = new ArrayList<Parcmetre>();
	boolean tousOccupes = false; 

	public ServiceInformation(){
		//ArrayList <Parcmetre> parcmetres = new ArrayList<Parcmetre>();
	}

	// ajoute un nouveau parcmètre à l’arrayList
	public void enregistrer(Parcmetre parcmetre){
		parcmetres.add(parcmetre);
	}


	// retourne le Parcmètre le plus proche de la localisation l
	public Parcmetre getParcmetre(Localisation l){		
		int min = 10000;
		int coord_min = 0;

		for(int i=0; i<parcmetres.size();i++){
			if(l.isProche(parcmetres.get(i).getposition(), min) && parcmetres.get(i).isOccupee() ){
				min = (int)l.distance(parcmetres.get(i).getposition());
				coord_min = i;
			}
		}
		return parcmetres.get(coord_min);
	}

	// retourne tous les parcmètres dont la distance à l est inférieure à distance.

	public ArrayList<Parcmetre> libreplusProche(Localisation l, int distance){
		
		ArrayList <Parcmetre> liste = new ArrayList<Parcmetre>(); 
		
		for(int i=0; i<parcmetres.size();i++){
			if(l.isProche(parcmetres.get(i).getposition(), distance) && parcmetres.get(i).isOccupee()){
				liste.add(parcmetres.get(i));		
			}
		}
		return liste;
	}

	//retourne true si tous les parcmetres sont occupés
	public boolean tousoccupes(){
		tousOccupes = true;
		for(int i=0; i<parcmetres.size();i++){
			if(parcmetres.get(i).tempsRestant() != 0)
				tousOccupes = false;
		}
		return tousOccupes;
	}
	
}
