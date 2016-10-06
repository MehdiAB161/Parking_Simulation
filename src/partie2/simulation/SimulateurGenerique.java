package partie2.simulation;

import java.util.ArrayList;

public abstract class SimulateurGenerique {


	protected ArrayList<Simulable> mesComposants; // liste des éléments simulés
	protected int nombreCycles; // nombre de cycles
	public SimulateurGenerique(int nombreCycles) { // initialisation desattributs
		this.nombreCycles=nombreCycles;

	}
	public abstract void generer(int nombredeVehicule, int nombredeParcmetres);
	// méthode à spécialiser par les classes filles pour renseigner mesComposants
	// la notation ... permet de ne pas donner le nombre de paramètres.
	// nombreParametres sera utilisé comme un tableau.
	public void simuler() {
		// execute nombreCycles de simulation
		// execute à chaque cycle tous les composants activables. }

	}

}