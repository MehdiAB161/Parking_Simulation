package  partie2.utilLocalisation;

import java.util.Comparator;

public class CompareSitue implements Comparator<Situe> {

	private Localisation position; 

	public CompareSitue(Localisation l) {
		position = new Localisation(l.getx(),l.gety());
	} 

	public int compare(Situe arg0, Situe arg1) { 
		// retourne un nombre positif si le plus �loign� de position est le premier argument ; 
		//un nombre n�gatif si c�est le second et 0 si les deux sont � m�me distance ;
		if(position.distance(arg0.getposition())>position.distance(arg1.getposition())){
			return 1;}
		else if(position.distance(arg0.getposition())<position.distance(arg1.getposition()))
		{ 
			return -1;}
		else
			return 0;
	} 
}