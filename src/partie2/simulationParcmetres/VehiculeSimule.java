package partie2.simulationParcmetres;

import java.util.ArrayList;

import partie2.application.IteratorLibre;
import partie2.application.MesParcmetres;
import partie2.application.Parcmetre;
import partie2.application.ServiceInformation;
import partie2.application.Vehicule;
import partie2.simulation.Simulable;
import partie2.utilLocalisation.Localisation;

public class VehiculeSimule extends Vehicule implements Simulable{

	private boolean  dejastationnee;//permet de savoir si le vehicule a déja stationnee 
	//Si le parcmetredestination sur lequel le vehicule et stationnee voit que le temps imparti au vehicule est ecoulée
	//Il se libère et pour éviter que le vehicule restationne sur ce parcmetre, on indique qu'il à déjà stationnee et on lui fait quitter le parking 
	//Cette variables et son accesseur sont utilisée dans la méthode aller de vehicule Simule pour spécifier qu'il faut la valider
	//Et dans la méthode décider pour savoir si le véhicule peut se garer  (seulement si nombre getnombrestationnemen()=true )


	public VehiculeSimule(Localisation position, Localisation destination,ServiceInformation si, boolean stationnee, int duree){ 


		super(position,si,stationnee,duree); //On utilise le constructeur de Vehicule
		dejastationnee=false; // On à jamais stationnee au début 
	}

	public VehiculeSimule(Localisation position, Localisation destination,ServiceInformation si, boolean stationnee){ 


		super(position,si,stationnee); //On utilise le constructeur de Vehicule
		dejastationnee=false; // On à jamais stationnee au début 
	}


	public VehiculeSimule(ServiceInformation si)
	{
		super(si);//On utilise le constructeur de Vehicule
		dejastationnee=false;
	}

	

	public void decider() 
	{
		if(!(getdejastationnee())){
			//On recherche le parcmetre le plus proche avant de se diriger
			//Au cas ou un parcmetre plus proche que le parcmetre destination se libère 


			//Variable intermediaire qui va contenir la liste des parcmetres par ordre croissant
			ArrayList<Parcmetre> alpha;
			alpha=(ArrayList<Parcmetre>) si.getparcmetres().plusProche(this.position);
			MesParcmetres mp2 = new MesParcmetres();
			for(int k=0;k<alpha.size();k++){
				mp2.ajouterElement(alpha.get(k));
			}//On créer mp pour pouvoir créer un Iterator libre du tableau triée


			IteratorLibre IT = new IteratorLibre(mp2);
			Parcmetre parc =new Parcmetre(this.si);
			if(IT.hasNext()==true )	{
				parc=IT.next();
				parcmetreDestination=parc ;
				destination=parcmetreDestination.getposition();
				aller(destination);
			}//On alloue le parcmetre libre le plus proche comme nouvelle destination
			//S'il n'y a aucun parcmetre de disonible le vehicule reste sur place jusqu'a ce qu'il y en ai un
		}
		else {
			Localisation l = new Localisation(0,0);
			aller(l); //Lorsque on arrive ici, c'est quele véhicule àdéja été garer, il sort du parking
			if(this.getposition().comparer(l)){
				this.affichable =false;
			}
		}
	}





	public void aller(Localisation l) {


		if(this.position.comparer(l))// On arrive donc on apelle arrive() qui effectue la réservation
		{                           // On affirme que l'on stationne donc stationnee = dejastationnee=true;

			arrive();
			stationnee=true;
			dejastationnee=true;
		}
		else
		{

			int unite=1;

			if(l.getx()-this.position.getx()>0)
			{
				this.position.deplacementDroite(unite);
			}
			else if(l.getx()-this.position.getx()<0)
			{
				this.position.deplacementGauche(unite);
			}
			else if(l.gety()-this.position.gety()>0)
			{
				this.position.deplacementHaut(unite);
			}
			else if(l.gety()-this.position.gety()<0)
			{
				this.position.deplacementBas(unite);
			}

		}// On spécifie le déplacement 
		//On pourrait faire des voiture de différente vitesse en modifiant unite

	}


	public void unPas() {
		if(!(aFini()))
		{

			decider() ;

		}
		else
		{
			this.alerte(parcmetreDestination.tempsRestant());
		
			if(parcmetreDestination.tempsRestant()==0){
				stationnee=false;
			}
		}

	}

	public boolean aFini(){

		if(stationnee)
		{
			return true;
		}
		else
		{
			return false;
		}



	} // retourne vrai si le vehicule est stationne }









	public boolean getdejastationnee(){
		return dejastationnee;
	}//renvoie si le vehicule a deja stationnee ou pas

	
	
}
