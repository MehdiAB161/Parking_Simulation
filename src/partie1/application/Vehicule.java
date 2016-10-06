package partie1.application;

import java.util.Random;



//*****//Toutes les variables de vehicule sont passé e private à protected (pour que vehicule simule puissent y acceder


public class Vehicule{
	/*la position est la localisation dynamique du Véhicule contrairement à destination qui est	statique.*/
	protected Localisation position,destination;
	/* l’objet Parcmetre est fourni par le service d’information
		suite à une interrogation du véhicule */
	protected Parcmetre parcmetreDestination;
	/* Il n’y a qu’un service d’information dans tout le problème private
		ServiceInformation si;*/
	protected ServiceInformation si ;
	/* indique si le véhicule est stationnée ou pas */
	protected boolean stationnee;
	/* duree correspond au temps pendant lequel le véhicule souhaite
		stationner. L’idde chaque véhicule doit être unique*/
	protected int id, duree;
	//Si le véhicule a déjà stationné
	boolean a_deja_stationne = false;
	// On a besoin de connaitre le nombre de vehicules pour donner la valeur de l'id
	private static int nombreDeVehicule=0;
	//Si le véhicule est affiché dans la fenêtre
	private boolean afficher = true;
	/* Création d’un véhicule en renseignant ses attributs ou générant des
		valeurs au hasard. */
	private static Random hasard = new Random();

	public Vehicule()
	{

	}

	public Vehicule(Localisation position, Localisation destination, ServiceInformation si, boolean stationnee) 
	{

		this.position = position;
		this.destination = destination;
		this.si=si;
		this.parcmetreDestination=si.getParcmetre(destination);
		this.stationnee = stationnee;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		duree =hasard.nextInt(500);
	}

	public Vehicule(ServiceInformation si) {

		this.position= new Localisation();
		this.si=si;
		this.parcmetreDestination=si.getParcmetre(this.position);
		this.destination=parcmetreDestination.getposition();
		//dureemax est a definir
		this.stationnee=false;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		duree =hasard.nextInt(500);
	}
	
	public Vehicule(Localisation position, Localisation destination, ServiceInformation si, boolean stationnee,int duree) 
	{

		this.position = position;
		this.destination = destination;
		this.si=si;
		this.parcmetreDestination=si.getParcmetre(destination);
		this.stationnee = stationnee;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		this.duree=duree;
	}

	/* correspond à l’interrogation du système d’information */
	public void demanderDisponibilite() 
	{   
		//Verfie que la méthode getPArcmetre retournera forcément une valeur
		if(!si.tousoccupes()){
			this.parcmetreDestination=si.getParcmetre(this.position);
			this.destination=parcmetreDestination.getposition();
		}

	}
	/* Si un parcmetre est disponible à proximité de sa	destination, le véhicule cherche à l’atteindre. Le véhicule peut
		également vérifier une fois avoir obtenue l’information que celle-ci est toujours valide.*/

	public void decider() 
	{
		
			if(parcmetreDestination.isOccupee())
			{
				this.aller((parcmetreDestination).getposition());
			}
			else
			{		
				this.demanderDisponibilite();
				//this.decider();
			}
		}


	/* un véhicule qui arrive au parcmètre l’interroge pour réserver un créneau de la durée demandée */
	protected void arrive() {
		//if(parcmetreDestination.isOccupee()){
		parcmetreDestination.reserver(duree);
		//}
	}
	/* permet de déplacer le véhicule comme sur une grille, le Véhicule se déplace d’une unité par pas de temps */



	public void aller(Localisation l) {
		if(this.position.comparer(l))
		{
			arrive();
			stationnee=true;
		}
		else
		{
			if(l.getx()-this.position.getx()>0)
			{
				this.position.deplacementDroite(1);
			}
			else if(l.getx()-this.position.getx()<0)
			{
				this.position.deplacementGauche(1);
			}
			else if(l.gety()-this.position.gety()>0)
			{
				this.position.deplacementHaut(1);
			}
			else if(l.gety()-this.position.gety()<0)
			{
				this.position.deplacementBas(1);
			}

		}

	}

	// alerte le conducteur du temps restant de sa reservation.
	protected void alerte(int d){
		System.out.println("Vehicule " + id + " il vous reste " + d +" temps de stationnement");
	}


	/* méthode appelée par le simulateur pour exécute le comportement du véhicule à
	un pas de temps */
	public void unPas() {
		if(!(aFini()))
		{

			if(!a_deja_stationne)
				decider() ;
			else{
				this.position.deplacementGauche(1);
				if(this.position.getx()==0)
					this.afficher = false;
			}

		}
		else 
		{
			alerte(parcmetreDestination.tempsRestant());
			if(parcmetreDestination.tempsRestant()== 0){
				stationnee = false;
				a_deja_stationne =true;
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

	
	//Utitlisée par la la fenêtre pour afficher le véhicule sur la grille
	public Localisation getposition(){
		return this.position;
	}
	
	//Utilisée par la fenêtre
	public boolean getafficher(){
		return this.afficher;
	}
}