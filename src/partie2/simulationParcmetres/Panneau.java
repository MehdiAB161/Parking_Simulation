package partie2.simulationParcmetres;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Panneau extends JPanel {
	private int pos_x;
	private int pos_y;
	private int nb_vehicules;
	private int nb_parcmetres;
	//Changement d'échelle de la fenêtre
	int multip_pas = 6;
	//Permet d'accéder aux informations sur les véhicules et les parcmètres
	private SimulateurParcmetre sim =new SimulateurParcmetre(0) ;

	//Méthode exécutée par défaut
	public void paintComponent(Graphics g) {



		//Effacement de l'image précédente
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Placement des parcmetres
		for(int l=0;l<nb_parcmetres;l++){
			try {
				//Affichage de l'image dans la position correspondante
				Image img = ImageIO.read(new File("Parcmetre.jpg"));
				pos_x=((ParcmetreSimule)sim.getmesComposants().get(l)).getposition().getx()*multip_pas;
				pos_y=((ParcmetreSimule)sim.getmesComposants().get(l)).getposition().gety()*multip_pas;
				g.drawImage(img,pos_x , pos_y, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Placement des voitures à leur position initiale
		for(int l=nb_parcmetres;l<nb_parcmetres + nb_vehicules ;l++){
			if(((VehiculeSimule)sim.getmesComposants().get(l)).getaffichable()){
				try {
					//Affichage de l'image dans la position correspondante
					Image img = ImageIO.read(new File("3.jpg"));
					pos_x=((VehiculeSimule)sim.getmesComposants().get(l)).getposition().getx()*multip_pas;
					pos_y=((VehiculeSimule)sim.getmesComposants().get(l)).getposition().gety()*multip_pas;
					g.drawImage(img,pos_x , pos_y, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	 //Setter de nb_parcmetres
	 void setnb_parcmetres(int nb_parcmetres) {
		this.nb_parcmetres = nb_parcmetres;
	}
	 //Setter de nb_vehicules
	 void setnb_vehicules(int nb_vehicules) {
		this.nb_vehicules = nb_vehicules;
	}

	 void setsim(SimulateurParcmetre sim) {
		this.sim = sim;
	}

}
