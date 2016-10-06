package partie2.simulation;

import java.util.ArrayList;

public abstract class SimulateurGenerique {


	protected ArrayList<Simulable> mesComposants; // liste des �l�ments simul�s
	protected int nombreCycles; // nombre de cycles
	public SimulateurGenerique(int nombreCycles) { // initialisation desattributs
		this.nombreCycles=nombreCycles;

	}
	public abstract void generer(int nombredeVehicule, int nombredeParcmetres);
	// m�thode � sp�cialiser par les classes filles pour renseigner mesComposants
	// la notation ... permet de ne pas donner le nombre de param�tres.
	// nombreParametres sera utilis� comme un tableau.
	public void simuler() {
		// execute nombreCycles de simulation
		// execute � chaque cycle tous les composants activables. }

	}

}