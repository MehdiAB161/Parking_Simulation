package partie1.application;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Panneau extends JPanel {
	private int pos_x;
	private int pos_y;
	int multip_pas = 6;
	Simulateur sim ;

	public void paintComponent(Graphics g) {

		//Effacement de l'image précédente
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//Placement des parcmetres
		for(int l=0;l<sim.getmesParcmetres().size();l++){ 
			try {
				//Affichage de l'image dans la position correspondante
				Image img = ImageIO.read(new File("Parcmetre.jpg"));
				pos_x=sim.getmesParcmetres().get(l).getposition().getx()*multip_pas;
				pos_y=sim.getmesParcmetres().get(l).getposition().gety()*multip_pas;
				g.drawImage(img,pos_x , pos_y, this);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}

		//Placement des voitures à leur position initiale
		for(int l=0;l<sim.getmesVehicules().size();l++){ 
			if(sim.getmesVehicules().get(l).getafficher()){
				try {
					//Affichage de l'image dans la position correspondante
					Image img = ImageIO.read(new File("3.jpg"));
					pos_x=sim.getmesVehicules().get(l).getposition().getx()*multip_pas;
					pos_y=sim.getmesVehicules().get(l).getposition().gety()*multip_pas;
					g.drawImage(img,pos_x , pos_y, this);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}

	}

	public void setsim(Simulateur sim) {
		this.sim = sim;
	}
}