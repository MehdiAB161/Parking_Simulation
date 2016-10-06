package partie2.application;


import partie2.utilLocalisation.Localisation;
import partie2.utilLocalisation.Situe;

//*****//Toutes les variables de vehicule sont pass� de private � protected (pour que vehicule simule puissent y acceder


public class Vehicule extends Situe{
	/*la position est la localisation dynamique du V�hicu
		le contrairement � destination qui est
		statique.*/
	protected Localisation destination;
	/* l�objet Parcmetre est fourni par le service d�information
		suite � une interrogation du v�hicule */
	protected Parcmetre parcmetreDestination;
	/* Il n�y a qu�un service d�information dans tout le probl�me private
		ServiceInformation si;*/
	protected ServiceInformation si ;
	/* indique si le v�hicule est stationn�e ou pas */
	protected boolean stationnee;
	/* duree correspond au temps pendant lequel le v�hicule souhaite
		stationner. L�idde chaque v�hicule doit �tre unique*/
	protected int id, duree;	
	// On a besoin de connaitre le nombre de vehicules pour donner la valeur de l'id
	private static int nombreDeVehicule=0;
	//D�termine si le v�hicule doit �tre affich� par la fen�tre
	//S'il sort du plateau apr�s avoir fini ses t�ches il ne doiplus �tre affich�
	protected boolean affichable =true;

	/* Cr�ation d�un v�hicule en renseignant ses attributs ou g�n�rant des
		valeurs au hasard. */


	public Vehicule()
	{

	}//*****************************************************************************

	public Vehicule(Localisation position, ServiceInformation si, boolean stationnee, int duree) 
	{	
		this.position = position;
		this.si=si;
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0);// Peu importe le parcmetredestination du d�part la m�thode un pas lui donnnera le plus proche
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
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0); // Peu importe le parcmetredestination du d�part la m�thode un pas lui donnnera le plus proche
		this.destination = this.parcmetreDestination.getposition();
		this.stationnee = stationnee;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		this.duree =100;
	}

	public Vehicule(ServiceInformation si) {

		this.position= new Localisation();
		this.parcmetreDestination=si.getParcmetre(this.position);
		this.parcmetreDestination=si.getparcmetres().getParcmetre(0);// Peu importe le parcmetredestination du d�part la m�thode un pas lui donnnera le plus proche
		this.stationnee=false;
		this.id=nombreDeVehicule+1;
		Vehicule.nombreDeVehicule=this.id;
		duree =100; //On prend une duree qui vaut 100 mais on aurait pu la choisir al�atoirement 
		this.si=si;
	}

	/* correspond � l�interrogation du syst�me d�information */
	public void demanderDisponibilite() 
	{   
		this.parcmetreDestination=si.getParcmetre(this.position);
		this.destination=parcmetreDestination.getposition();
	}

	// un v�hicule qui arrive au parcm�tre l�interroge pour r�server un cr�neau de la dur�e demand�e 
	protected void arrive() {
		parcmetreDestination.reserver(duree);

	}

	// alerte le conducteur du temps restant de sa reservation.
	protected void alerte(int d){
	
		System.out.println("Vehicule "+id+ " Il vous reste�" + d +"�temps de stationnement");
	}

	//Retrourne � la fen�tre si le v�hicule doit �tre affich�
	public boolean getaffichable(){
		return affichable;
	}
}