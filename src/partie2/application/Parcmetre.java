package partie2.application;
import java.util.Random;

import partie2.utilLocalisation.Localisation;
import partie2.utilLocalisation.Situe;

public class Parcmetre extends Situe{

	// Temps restant pour un v�hicule en stationnement. Chaque id est unique
	@SuppressWarnings("unused")
	private int dureeReservation = 0, id;
	//On a besoin de connaitre le nombre de parcmetre pour donner la valeur de l'id
	private static int nombreDeParcmetre=0;
	// le service d�information est le m�me pour tous les parcm�tres
	private ServiceInformation si ;
	// Retourne vraie si la dur�e de r�servation est � 0.
	private static Random hasard = new Random();

	public boolean isOccupee(){
		if(dureeReservation == 0)
			return true;
		else
			return false;
	}

	// le service d�information est le m�me pour tous les parcm�tres
	public Parcmetre(Localisation position, ServiceInformation si){
		this.position = position;
		Parcmetre.nombreDeParcmetre=Parcmetre.nombreDeParcmetre++;
		this.id=Parcmetre.nombreDeParcmetre;
		this.si=si;
		/*	 
	 si.enregistrer(this);  */
	}

	// la localisation est al�atoire.
	public Parcmetre(ServiceInformation si){
		this.position =new Localisation();
		for(int i=0; i<nombreDeParcmetre;i++){  
			if(this.getposition().comparer(si.getparcmetres().getParcmetre(i).getposition())){
				this.getposition().setLocalisation(hasard.nextInt(100), hasard.nextInt(100));
				i=0;
			}//On v�rifie qu'un Parcmetre n'occupe pas d�j� cette place
		}
		Parcmetre.nombreDeParcmetre=Parcmetre.nombreDeParcmetre++;
		this.id=Parcmetre.nombreDeParcmetre;  
		this.si=si;
	}


	// Retourne le temps restant avant lib�ration de la place.
	public int tempsRestant(){
		return dureeReservation;
	}
	// r�alise une r�servation d�une dur�e d ou du temps maximum autoris� pour tousles parcm�tres.
	public void reserver(int d){
		dureeReservation = d;		
	}

	// lib�re la place de stationnement en mettant la duree de reservation � 0
	public void liberer(){
		dureeReservation =0;
	}

	// permet au parcm�tre d��tre enregistr� aupr�s du syst�me d�information.
	public void enregistrer(){
		si.enregistrer(this);
	}

	/*public void unPas(){

}*/
	public ServiceInformation getsi(){
		return si;
	}//On a besoin de retrouver si, pour initialiser nos variable interm�diaire de tye Parcmetre dans Iterator Libre

}