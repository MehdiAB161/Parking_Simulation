package partie1.application;

import java.util.Random;



//*****//Toutes les variables de vehicule sont pass� e private � protected (pour que vehicule simule puissent y acceder


public class Vehicule{
	/*la position est la localisation dynamique du V�hicule contrairement � destination qui est	statique.*/
	protected Localisation position,destination;
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
	//Si le v�hicule a d�j� stationn�
	boolean a_deja_stationne = false;
	// On a besoin de connaitre le nombre de vehicules pour donner la valeur de l'id
	private static int nombreDeVehicule=0;
	//Si le v�hicule est affich� dans la fen�tre
	private boolean afficher = true;
	/* Cr�ation d�un v�hicule en renseignant ses attributs ou g�n�rant des
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

	/* correspond � l�interrogation du syst�me d�information */
	public void demanderDisponibilite() 
	{   
		//Verfie que la m�thode getPArcmetre retournera forc�ment une valeur
		if(!si.tousoccupes()){
			this.parcmetreDestination=si.getParcmetre(this.position);
			this.destination=parcmetreDestination.getposition();
		}

	}
	/* Si un parcmetre est disponible � proximit� de sa	destination, le v�hicule cherche � l�atteindre. Le v�hicule peut
		�galement v�rifier une fois avoir obtenue l�information que celle-ci est toujours valide.*/

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


	/* un v�hicule qui arrive au parcm�tre l�interroge pour r�server un cr�neau de la dur�e demand�e */
	protected void arrive() {
		//if(parcmetreDestination.isOccupee()){
		parcmetreDestination.reserver(duree);
		//}
	}
	/* permet de d�placer le v�hicule comme sur une grille, le V�hicule se d�place d�une unit� par pas de temps */



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
		System.out.println("Vehicule " + id + " il vous reste�" + d +"�temps de stationnement");
	}


	/* m�thode appel�e par le simulateur pour ex�cute le comportement du v�hicule �
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

	
	//Utitlis�e par la la fen�tre pour afficher le v�hicule sur la grille
	public Localisation getposition(){
		return this.position;
	}
	
	//Utilis�e par la fen�tre
	public boolean getafficher(){
		return this.afficher;
	}
}