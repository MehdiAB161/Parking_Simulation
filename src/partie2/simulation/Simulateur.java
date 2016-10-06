package partie2.simulation;
import java.util.ArrayList;

import partie2.application.Parcmetre;
import partie2.application.ServiceInformation;
import partie2.application.Vehicule;


public class Simulateur {

	private	 ArrayList<Vehicule> 	mesVehicules	; 
	private	 ArrayList<Parcmetre> 	mesParcmetres	; 
	private	 ServiceInformation 	si ; 
	// nombre de pas de temps (cycle) ex�cut� par le simulateur. 
	private	int	nombreCycles; 
	// initialise les diff�rents attributs. 
	public	 Simulateur(){

	}
	//  g�n�re  al�atoirement p	  parcm�tres  qui  s�enregistre  aupr�s  du  syst�me  d�in	formation  et	v	v�hicules.  
	public	void	 generer(int p, int v)  {
		for(int i=0; i<v; i++)
			mesVehicules.add(new Vehicule(si));
		for(int i = 0; i<p; i++)
			mesParcmetres.add(new Parcmetre(si));
	}
	// ex�cute la simulation pour les nombreCycles pr�v	us. 
	public	void simuler()  {

	}

	int getnombreCycles(){
		return nombreCycles;
	}

}


