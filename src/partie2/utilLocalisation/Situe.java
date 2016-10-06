package partie2.utilLocalisation;


public abstract class Situe {

	public Situe()
	{

	}

	protected Localisation position;

	public Situe (Localisation position)
	{
		this.position=position;
	}

	public Situe (int x, int y)
	{
		this.position.setLocalisation(x,y);
	}


	public Localisation getposition()
	{
		return  position;
	}
}


