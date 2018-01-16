/**
 * Subclass of Element for path map object
 */
public class Path extends Element
{

	/**
	 * Creates a new Path object and calls the Element parent class
	 * @param  i Row location
	 * @param  j Column location
	 */
	public Path(int i, int j)
	{
		super(i,j);
	}

	/**
	 * The collision action for when the character collides with the 
	 * Path  object location
	 * @param character Character object of type character
	 */
	public void doCollision(Character character)
	{
		//Do nothing
	}
}