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
	}//On g�n�re des v�hicule � la position al�atoire

	public void simuler() {
		for(int k=0;k<=nombreCycles;k++)
		{   
			for(int l=0;l<mesComposants.size();l++)
				mesComposants.get(l).unPas();
			System.out.println(" Il reste " + (nombreCycles - k) + " cycles");
			//On actualise la fen�tre
			FenetreSimulation.actualiser();
		}
	}//On g�re la simulation 

	//Getter utilis� par le panneau d'affichage
		ArrayList<Simulable> getmesComposants()
		{
			return mesComposants;
		}//On � besoin de conna�tre le tableau des composants 

		
	public static void main(String[] args) {
		SimulateurParcmetre Allo=new SimulateurParcmetre(500,10,15);
		Allo.simuler();
	}

	
}

