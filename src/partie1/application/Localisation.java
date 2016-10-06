package  partie1.application;

import java.util.Random;

public class Localisation {

	private int x, y;
	private static Random hasard = new Random();
	// crée une Localisation aux coordonnées indiquées
	public Localisation(int x, int y)
	{
		this.x=x;
		this.y=y;
	}

	// créé une Localisation avec des coordonnées aléatoires.
	public Localisation()
	{
		this.x=hasard.nextInt(100);
		this.y=hasard.nextInt(100);
	}

	// permet une version de l’objet en String sous la forme (x, y)
	public String toString()
	{   
		String affich=new String();
		affich="(" +this.x +"," +this.y +")";
		return affich;
	}

	// retourne vraie si la distance entre les positions est inférieure
	//à la marge
	public boolean isProche(Localisation l2, int marge)
	{
		if(this.distance(l2)<marge)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// retourne la distance à la localisation donnée en paramètre.
	public double distance(Localisation l)
	{ 
		int d=0;
		d= (int) Math.sqrt(Math.pow(this.x-l.x,2)+Math.pow(this.y-l.y,2));
		return d;
	}


	// méthode pour modifier une localisation selon les limites de la
	//grille
	public void deplacementDroite(int deplacementd)
	{
		int d=this.x+ deplacementd;
		if(d>100)
		{
			this.x=100;
		}
		else
		{
			this.x=d;
		}
	}

	public void deplacementGauche(int deplacementg)
	{

		int d=this.x-deplacementg;
		if(d<0)
		{
			this.x=0;
		}
		else
		{
			this.x=d;
		}
	}

	public void deplacementBas(int deplacementb)
	{

		int d=this.y-deplacementb;
		if(d<0)
		{
			this.y=0;
		}
		else
		{
			this.y=d;
		}
	}

	public void deplacementHaut(int deplacementh)
	{
		int d=this.y+deplacementh;
		if(d>100)
		{
			this.y=100;
		}
		else
		{
			this.y=d;
		}
	}
	
	//Compare la localisation actuelle à la localisation P2
	public boolean comparer(Localisation P2){
		if (this.x == P2.getx() & this.y == P2.gety())
			return true;
		else
			return false;
	}
	
	//Setter de x et y
	public void setLocalisation(int x, int y){
		this.x =x;
		this.y=y;
	}
	
	//Getters de x et y
	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}
}

