package partie2.application;

//import java.util.ArrayList;
import java.util.Iterator;

//import utilLocalisation.Situe;


import partie2.application.Parcmetre;

public class IteratorLibre implements Iterator<Parcmetre>  {

	Parcmetre courant; // Parcmetre � retourner
	Iterator<Parcmetre> it  ; // iterator de MesParcmetres
	MesParcmetres x; // On a besoin d'une copie de mp pour obtenir l'indice sur lequel on s'est arr�ter a
	// ux dernier appelle de this.next().Car on ne peut pas parcourir mp avec it.next() dans this.hasNext() pour trouver 
	//  le pacmetre suivant libre (s'il existe) sinon le curseur de it "s'avance".
	//  Une autre solution aurait consister � cr�er une variable static qui garde en m�moire l'indice dans mp
	//  du dernier objet retourner dans this.next()  

	public IteratorLibre(MesParcmetres mp)
	{   
		courant=new Parcmetre(mp.getParcmetre(0).getsi());  //On initialise courant avec le syst�me d'infos des parcmetres de la simulation
		x= new MesParcmetres();
		x=mp; 
		it=x.iterator();
	}//{ initialisation des attributs }

	public boolean hasNext() {
		for(int i=0;i<=x.nombreElement();i++){
			if(it.hasNext()==true)
			{   
				courant=it.next();
				int v=0; //variable qui va contenir l'indice l'indice � partir duquel this.next() devra rechercher le parmetre libre s'il existe 
				for(int m=0;m<x.nombreElement();m++)
				{
					if(courant==x.getParcmetre(m))
					{
						v=m;
						m=x.nombreElement();
					}
				}//On r�cup�re l'indice � partir duquel this.next() devra rechercher le parmetre libre s'il existe

				for(int m=v;m<x.nombreElement();m++)
				{
					if(x.getParcmetre(m).isOccupee())
					{
						return true;
					}
				}//On cherche un parcmetre libre � partir de v
			}
		}
		return false;
	}   // retourne vraie si le prochain appel de next ne retourne pas d'erreur:
	// il existe un Parcmetre de libre

	public Parcmetre next(){
		Parcmetre courant2 =new Parcmetre(x.getParcmetre(0).getsi()); //Variable qui permet de tester si l'�l�ment courant 
		//sur lequel hasnext() nous � placer est libre ou pas 

		for(int i=0;i<x.nombreElement();i++){
			if(it.hasNext()==true)
			{   
				if(i==0){
					courant2=courant;}
				else{courant2=it.next(); }
				if(courant2.isOccupee()==true){
					courant=courant2;
					return courant;
				}
			}
		}
		// retourne l'�l�ment courant et recherche le suivant.}
		return courant;
	}

	
}