package partie1.application;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Panneau pan = new Panneau();

	Fenetre(int cote_fenetre, Simulateur sim ) {

		this.setTitle("Traffic"); //Titre de la fenêtre
		this.setResizable(false); //Taille non modifiable
		this.actualiser(); //Raffraichit la fenêtre
		this.setSize(cote_fenetre, cote_fenetre); //Définit la taille de la fenentre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initialiser_pan(sim); //initialisation du simulateur du panneau
		this.setContentPane(pan);
		this.setVisible(true);
	}

	void actualiser() {
		pan.repaint();  //Rafraîchit l'mage
		try {
			Thread.sleep(100); //Défninit la vitesse de l'animation
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Défninit les paramètres de pan
	//On les définit en utilisant cette méthode car on ne peut pas créer un constructeur de pan
	private void initialiser_pan(Simulateur sim){
		this.pan.setsim(sim);
	}
}