package partie2.simulation;
import java.util.ArrayList;

import partie2.application.Parcmetre;
import partie2.application.ServiceInformation;
import partie2.application.Vehicule;


public class Simulateur {

	private	 ArrayList<Vehicule> 	mesVehicules	; 
	private	 ArrayList<Parcmetre> 	mesParcmetres	; 
	private	 ServiceInformation 	si ; 
	// nombre de pas de temps (cycle) exécuté par le simulateur. 
	private	int	nombreCycles; 
	// initialise les différents attributs. 
	public	 Simulateur(){

	}
	//  génère  aléatoirement p	  parcmètres  qui  s’enregistre  auprès  du  système  d’in	formation  et	v	véhicules.  
	public	void	 generer(int p, int v)  {
		for(int i=0; i<v; i++)
			mesVehicules.add(new Vehicule(si));
		for(int i = 0; i<p; i++)
			mesParcmetres.add(new Parcmetre(si));
	}
	// exécute la simulation pour les nombreCycles prév	us. 
	public	void simuler()  {

	}

	int getnombreCycles(){
		return nombreCycles;
	}

}


