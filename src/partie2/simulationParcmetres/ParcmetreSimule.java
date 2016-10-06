package partie2.simulationParcmetres;

import partie2.application.Parcmetre;
import partie2.application.ServiceInformation;
import partie2.simulation.Simulable;
import partie2.utilLocalisation.Localisation;

public class ParcmetreSimule extends Parcmetre implements Simulable{

	public ParcmetreSimule(Localisation position, ServiceInformation si) { 
		super(position,si); //On utilise le constructeur de Parcmetre
	}

	public ParcmetreSimule(ServiceInformation si)
	{
		super(si);//On utilise le constructeur de Parcmetre
	}

	public void unPas() {

		if(!this.aFini())
		{
			if(!this.isOccupee())
			{
				reserver(tempsRestant()-1); 
			}	
		}//On définit le comortement du Parcmetresimule pour un pas de temps
		//S'il est libre il ne fait rien 
		//S'il est occuer il verifie que le vehicule a le droit de se stationner , sinon il se libère

		//L'actualisation se fait toute seule car il s'adit de passage par adresse.	

	}
	public boolean aFini() {// toujours faux}
		return false;
	}

}
