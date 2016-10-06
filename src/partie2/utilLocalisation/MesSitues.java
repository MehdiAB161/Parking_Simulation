package  partie2.utilLocalisation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MesSitues <T extends Situe> implements Iterable<T>{ 



	protected ArrayList<T> mp = new ArrayList<T>(); 

	public void afficher(Iterator<T> it) { 
		// affiche les éléments contenus dans mp selon l'ordre de l'iterateur passé en paramètre.
		while(it.hasNext()){
			System.out.println(" "+it.next().getposition());
		}
	} 

	public void affichertout() { //affiche les éléments dans l'ordre d'enregistrement dans l'ArrayList
		afficher(mp.iterator());
	} 
	protected T getElementSitue(int i){
		//retourne le ieme élèment de mp 
		return mp.get(i);
	} 
	public int nombreElement(){// retourne la taille de mp
		return mp.size();
	}

	public void ajouterElement(T e){ 
		// ajoute e à mp
		mp.add(e);
	} 
	public Collection<T> plusProche(Localisation l){ 
		// retourne une copie ordonnee de mp selon ComparatorSitue
		
		//Le code ci dessous utilise la fonction sort de arraylist
		//Le problème est que des qu'un parcmetre se libère, il le considère comme étant le plus proche...
		
		/*CompareSitue comparateur = new CompareSitue(new Localisation(0,0));
		ArrayList<T> beta =  new ArrayList<T>();
		beta.addAll(mp);
		beta.sort(comparateur);
		return (Collection<T>)beta;*/
		

		
		CompareSitue z= new CompareSitue(l); //On crée notre comparateur
		ArrayList<T> x = new ArrayList<T>(); //On crée un tableau auxilliaire de tri

		for(int p=0;p<this.mp.size();p++)
			x.add(null);

		for(int j=0;j<this.mp.size();j++)
		{
			int i=0;
			for(i = 0;i<this.mp.size()-1;i++) 
			{
				if(z.compare(this.mp.get(i+1),this.mp.get(i))>0){
					x.set(i,this.mp.get(i));
					x.set(i+1,this.mp.get(i+1)); }
				else if(z.compare(this.mp.get(i+1),this.mp.get(i))<0){
					x.set(i,this.mp.get(i+1));
					x.set(i+1,this.mp.get(i));}
				else{
					x.set(i,this.mp.get(i));
					x.set(i+1,this.mp.get(i+1));
				}
				mp.set(i, x.get(i));
				mp.set(i+1, x.get(i+1));
			}
		}
		return (Collection<T>)mp; 
	}
	
	// retourne l’iterator de mp
	public Iterator<T> iterator() 
	{
		return mp.iterator();
	} 

}
