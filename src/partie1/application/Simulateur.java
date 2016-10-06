package partie1.application;
import java.util.ArrayList;


public class Simulateur {

	private	 ArrayList<Vehicule> 	mesVehicules	= new ArrayList<Vehicule>(); 
	private	 ArrayList<Parcmetre> 	mesParcmetres = new ArrayList<Parcmetre>()	; 
	private	 ServiceInformation 	si = new ServiceInformation() ; 
	private Fenetre FenetreSimulation; //Fenetre pour l'interface graphique
	// nombre de pas de temps (cycle) exécuté par le simulateur. 
	private	int	nombreCycles = 500; 
	private int cycles_restants = 0;
	//Paramètres initialisés par le constructeur par défaut
	private int taille_fenetre =700;
	// initialise les différents attributs. 

	//Constructeur par défaut
	public	 Simulateur(){
		this(10,10,500);
	}
	//Constructeur avec le nombre de parcmetres et de vehicules
	public	 Simulateur(int p, int v){
		this.generer(p,v);
		this.simuler();
	}
	//Constructeur avec le nombre de cycles en plus du nombre de parcmetres et de vehicules
	public	 Simulateur(int p, int v, int nombrecycles){
		this(p,v);
		nombreCycles = nombrecycles;
	}

	//  génère  aléatoirement p	  parcmètres  qui  s’enregistre  auprès  du  système  d’in	formation  et	v	véhicules.  
	public	void generer(int p,	int v)  {

		for(int i = 0; i<p; i++){
			Parcmetre parc = new Parcmetre(si);
			mesParcmetres.add(parc);
			si.enregistrer(parc);
		}
		for(int i=0; i<v; i++){
			Vehicule vehicule = new Vehicule(si);
			mesVehicules.add(vehicule);
		}
		
		// Construction de la fenêtre pour l'interface graphique
		FenetreSimulation=new Fenetre(taille_fenetre, this);
		
	}

	// exécute la simulation pour les nombreCycles prév	us. 
	public	void simuler()  {
		int j =0;
		while(j<nombreCycles){
			for(int i=0; i<mesVehicules.size(); i++)
				mesVehicules.get(i).unPas();
			for(int i=0; i<mesParcmetres.size(); i++)
				mesParcmetres.get(i).unPas();
			FenetreSimulation.actualiser();
			j++;
			cycles_restants = nombreCycles - j;
			System.out.println("Il reste" + cycles_restants + "cycles" );
		}
	}
	
	// Getters utilisés par le Panneau d'affichage
	ArrayList<Vehicule> getmesVehicules(){
		return mesVehicules;
	}
	
	ArrayList<Parcmetre> getmesParcmetres(){
		return mesParcmetres;
	}
	
	//retourne le nombre de cycles
	int getnombreCycles(){
		return nombreCycles;
	}
	
	//main du projet
	public static void main(String[] args) {
		Simulateur Traffic=new Simulateur(15,25,500);
	}
	

	
}