package partie1.application;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Panneau pan = new Panneau();

	Fenetre(int cote_fenetre, Simulateur sim ) {

		this.setTitle("Traffic"); //Titre de la fen�tre
		this.setResizable(false); //Taille non modifiable
		this.actualiser(); //Raffraichit la fen�tre
		this.setSize(cote_fenetre, cote_fenetre); //D�finit la taille de la fenentre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initialiser_pan(sim); //initialisation du simulateur du panneau
		this.setContentPane(pan);
		this.setVisible(true);
	}

	void actualiser() {
		pan.repaint();  //Rafra�chit l'mage
		try {
			Thread.sleep(100); //D�fninit la vitesse de l'animation
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//D�fninit les param�tres de pan
	//On les d�finit en utilisant cette m�thode car on ne peut pas cr�er un constructeur de pan
	private void initialiser_pan(Simulateur sim){
		this.pan.setsim(sim);
	}
}