/**
 * Subclass of Element for deadly map objects
 */
public class Deadly extends Element
{
	
	/**
	 * Creates a new Deadly object and calls the Element parent class
	 * @param  i Row location
	 * @param  j Column location
	 */
	public Deadly(int i, int j)
	{
		super(i,j);
	}

	/**
	 * The collision action for when the character collides with the 
	 * deadly object location
	 * @param character Character object of type character
	 */
	public void doCollision(Character character)
	{
		character.die();
	}

}