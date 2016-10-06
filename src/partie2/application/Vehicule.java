package partie2.application;


import partie2.utilLocalisation.Localisation;
import partie2.utilLocalisation.Situe;

//*****//Toutes les variables de vehicule sont passé de private à protected (pour que vehicule simule puissent y acceder


public class Vehicule extends Situe{
	/*la position est la localisation dynamique du Véhicu
		le contrairement à destination qui est
		statique.*/
	protected Localisation destination;
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
	// On a besoin de connaitre le nombre de vehicules pour donner la valeur de l'id
	private static int nombreDeVehicule=0;
	//Détermine si le véhicule doit être affiché par la fenêtre
	//S'il sort du plateau après avoir fini ses tâches il ne doiplus être affiché
	protected boolean affichable =true;

	/* Création d’un véhicule en renseignant ses attributs ou générant des
		valeurs au hasard. */


	public Vehicule()
	{

	}//*****************************************************************************

	public Vehicule(Localisation position, ServiceInformation si, boolean stationnee, int duree) 
	{	
		this.position = position;
		this.si=si;
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0);// Peu importe le parcmetredestination du départ la méthode un pas lui donnnera le plus proche
		this.destination = this.parcmetreDestination.getposition();
		
		this.stationnee = stationnee;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		this.duree =duree;
	}

	public Vehicule(Localisation position, ServiceInformation si, boolean stationnee) 
	{	
		this.position = position;
		this.si=si;
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0); // Peu importe le parcmetredestination du départ la méthode un pas lui donnnera le plus proche
		this.destination = this.parcmetreDestination.getposition();
		this.stationnee = stationnee;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		this.duree =100;
	}

	public Vehicule(ServiceInformation si) {

		this.position= new Localisation();
		this.parcmetreDestination=si.getParcmetre(this.position);
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0);// Peu importe le parcmetredestination du départ la méthode un pas lui donnnera le plus proche
		this.stationnee=false;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		duree =100; //On prend une duree qui vaut 100 mais on aurait pu la choisir aléatoirement 
		this.si=si;
	}

	/* correspond à l’interrogation du système d’information */
	public void demanderDisponibilite() 
	{   
		this.parcmetreDestination=si.getParcmetre(this.position);
		this.destination=parcmetreDestination.getposition();
	}

	// un véhicule qui arrive au parcmètre l’interroge pour réserver un créneau de la durée demandée 
	protected void arrive() {
		parcmetreDestination.reserver(duree);

	}

	// alerte le conducteur du temps restant de sa reservation.
	protected void alerte(int d){
	
		System.out.println("Vehicule "+id+ " Il vous reste " + d +" temps de stationnement");
	}

	//Retrourne à la fenêtre si le véhicule doit être affiché
	public boolean getaffichable(){
		return affichable;
	}
}