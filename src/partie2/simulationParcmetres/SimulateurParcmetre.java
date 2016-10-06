package partie2.simulationParcmetres;

import java.util.ArrayList;

import partie2.application.ServiceInformation;
import partie2.simulation.Simulable;
import partie2.simulation.SimulateurGenerique;


public class SimulateurParcmetre extends SimulateurGenerique{

	private ServiceInformation si = new ServiceInformation();
	private Fenetre FenetreSimulation;

	public SimulateurParcmetre(int nombreCycles) {
		super(nombreCycles);
		mesComposants=new ArrayList<Simulable>();
	}

	public SimulateurParcmetre(int nombreCycles, int p, int v) {
		this(nombreCycles);
		this.generer(p,v);
	}

	public	void generer(int p, int	 v)  {

		for(int i = 0; i<p; i++)
		{   
			ParcmetreSimule parc=new ParcmetreSimule(si);
			si.enregistrer(parc);
			mesComposants.add(parc);
		}
		for(int i=0; i<v; i++)
		{   
			VehiculeSimule vehi=new VehiculeSimule(si);
			mesComposants.add(vehi);
		}
		FenetreSimulation=new Fenetre(750, this, v, p);	
	}//On génère des véhicule à la position aléatoire

	public void simuler() {
		for(int k=0;k<=nombreCycles;k++)
		{   
			for(int l=0;l<mesComposants.size();l++)
				mesComposants.get(l).unPas();
			System.out.println(" Il reste " + (nombreCycles - k) + " cycles");
			//On actualise la fenêtre
			FenetreSimulation.actualiser();
		}
	}//On gère la simulation 

	//Getter utilisé par le panneau d'affichage
		ArrayList<Simulable> getmesComposants()
		{
			return mesComposants;
		}//On à besoin de connaître le tableau des composants 

		
	public static void main(String[] args) {
		SimulateurParcmetre Allo=new SimulateurParcmetre(500,10,15);
		Allo.simuler();
	}

	
}

